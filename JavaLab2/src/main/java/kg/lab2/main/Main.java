package kg.lab2.main;

import java.io.*;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Deque<Double> stack = new ArrayDeque<>();
        Map<String, Double> variables = new HashMap<>();
        CommandFactory factory = new CommandFactory();
        BufferedReader reader;
        String line;

        if (args.length > 0) {
            try {
                reader = new BufferedReader(new FileReader(args[0]));
                logger.info("File opened: {}", args[0]);
            } catch (IOException e) {
                System.err.println("Error while open file: " + e.getMessage());
                logger.error("Error while open file: {}", e.getMessage());
                return;
            }
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        logger.info("Calculator started");

        try {
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                String[] parts = line.split(" ");
                String commandName = parts[0];
                List<String> arguments = Arrays.asList(parts).subList(1, parts.length);

                try {
                    Command command = factory.create(commandName);
                    logger.info("Executing command: {} {}", commandName, arguments);
                    command.execute(stack, variables, arguments);
                } catch (Exception e) {
                    String message = !(e.getMessage() == null) ? e.getMessage() : "Empty stack";
                    logger.error("Error while executing command '{}': {}", commandName, message);
                    System.err.println("Error: " + message);
                }
            }
            logger.info("File with commands ended");
        } catch (IOException e) {
            logger.error("Error while reading file: {}", e.getMessage());
            System.err.println("Error while reading file: " + e.getMessage());
        }
    }
}

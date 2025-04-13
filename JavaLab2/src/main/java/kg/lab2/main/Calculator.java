package kg.lab2.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import kg.lab2.main.CalculatorException.*;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);
    Context context;
    CommandFactory factory;

    public Calculator() throws Exception {
        context = new Context();
        factory = new CommandFactory();
    }

    public void start(BufferedReader reader) {
        String line;
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
                    command.execute(context, arguments);
                } catch (CalculatorException e) {
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

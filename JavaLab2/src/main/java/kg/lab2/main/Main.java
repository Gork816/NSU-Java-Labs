package kg.lab2.main;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Deque<Double> stack = new ArrayDeque<>();
        Map<String, Double> variables = new HashMap<>();
        CommandFactory factory = new CommandFactory();
        BufferedReader reader;
        String line;

        if (args.length > 0) {
            try {
                reader = new BufferedReader(new FileReader(args[0]));
            } catch (IOException e) {
                System.err.println("Error while open file: " + e.getMessage());
                return;
            }
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                String[] parts = line.split(" ");
                String commandName = parts[0];
                List<String> arguments = Arrays.asList(parts).subList(1, parts.length);

                try {
                    Command command = factory.create(commandName);
                    command.execute(stack, variables, arguments);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error while reading: " + e.getMessage());
        }
    }
}

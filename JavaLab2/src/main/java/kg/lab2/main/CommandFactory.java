package kg.lab2.main;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class CommandFactory {
    private final Properties commandMappings = new Properties();

    public CommandFactory() {
        try (InputStream input = getClass().getResourceAsStream("/commands.properties")) {
            if (input != null) {
                commandMappings.load(input);
            } else {
                throw new RuntimeException("Configuration file was not found");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while loading configuration file", e);
        }
    }

    public Command create(String commandName) throws Exception {
        String className = commandMappings.getProperty(commandName);
        if (className == null) {
            throw new IllegalArgumentException("Unknown command: " + commandName);
        }
        try {
            return (Command) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error while creating command: " + commandName, e);
        }
    }
}


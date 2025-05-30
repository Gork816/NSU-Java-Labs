package kg.lab2.main;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;
import kg.lab2.main.CalculatorException.*;

public class CommandFactory {
    private final Properties commandMappings = new Properties();

    public CommandFactory() throws ConfigException {
        try (InputStream input = getClass().getResourceAsStream("/commands.properties")) {
            if (input != null) {
                commandMappings.load(input);
            } else {
                throw new ConfigException("Configuration file was not found");
            }
        } catch (IOException e) {
            throw new ConfigException("Error while loading configuration file:" + e.getMessage());
        }
    }

    public Command create(String commandName) throws CommandCreateException {
        String className = commandMappings.getProperty(commandName);
        if (className == null) {
            throw new CommandCreateException("Unknown command: " + commandName);
        }
        try {
            return (Command) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new CommandCreateException("Error while creating command: " + commandName + e);
        }
    }
}


package kg.lab2.main;

import java.io.*;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import kg.lab2.main.CalculatorException.*;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Context context = new Context();
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

        try {
            Calculator calculator = new Calculator();
            logger.info("Calculator started");
            calculator.start(reader);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

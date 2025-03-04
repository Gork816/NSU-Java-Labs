package kg.lab1.main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar JavaLab1.jar <file>");
            return;
        }

        String inputFilename = args[0];
        String outputFilename = "output.csv";

        Set<WordEntry> wordEntries = WordProcessor.processFile(inputFilename);
        CSVWriter.writeToFile(outputFilename, wordEntries);

        System.out.println("CSV file created: " + outputFilename);
    }
}


package kg.lab1.main;

import java.io.*;
import java.util.*;

public class CSVWriter {
    public static void writeToFile(String filename, Set<WordEntry> wordEntries) {
        List<WordEntry> sortedWords = new ArrayList<>(wordEntries);
        sortedWords.sort((a, b) -> Integer.compare(b.getCount(), a.getCount()));

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (WordEntry entry : sortedWords) {
                //Locale.US for point in percentage cell
                writer.printf(Locale.US,"%s,%d,%.2f%%%n", entry.getWord(), entry.getCount(), entry.getPercentage());
            }
        } catch (IOException e) {
            System.err.println("Error while writing CSV file: " + e.getMessage());
        }
    }
}


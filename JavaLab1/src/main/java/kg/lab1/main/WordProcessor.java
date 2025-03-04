package kg.lab1.main;

import java.io.*;
import java.util.*;

public class WordProcessor {
    public static Set<WordEntry> processFile(String filename) {
        Map<String, Integer> wordCount = new HashMap<>();
        int totalWords = 0;
        try (Reader reader = new InputStreamReader(new FileInputStream(filename))) {
            StringBuilder word = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                if (Character.isLetterOrDigit(ch)) {
                    word.append((char) ch);
                } else if (!word.isEmpty()) {
                    wordCount.put(word.toString(), wordCount.getOrDefault(word.toString(), 0) + 1);
                    word.setLength(0);
                    totalWords++;
                }
            }
            //check for last word
            if (!word.isEmpty()) {
                wordCount.put(word.toString(), wordCount.getOrDefault(word.toString(), 0) + 1);
                totalWords++;
            }
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getMessage());
        }

        Set<WordEntry> wordEntries = new HashSet<>();

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            double percentage = (entry.getValue() * 100.0) / totalWords;
            wordEntries.add(new WordEntry(entry.getKey(), entry.getValue(), percentage));
        }

        return wordEntries;
    }
}


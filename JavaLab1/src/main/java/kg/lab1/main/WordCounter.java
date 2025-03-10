package kg.lab1.main;

import java.io.*;
import java.util.*;

public class WordCounter {

    Set<WordEntry> stat;

    public void processFile(String filename) {
        Map<String, Integer> wordCount = new HashMap<>();
        int totalWords = 0;
        try (Reader reader = new InputStreamReader(new FileInputStream(filename))) {
            StringBuilder word = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                if (Character.isLetterOrDigit(ch)) {
                    word.append((char) ch);
                } else if (!word.isEmpty()) {
                    wordCount.merge(word.toString(), 1, Integer::sum);
                    word.setLength(0);
                    totalWords++;
                }
            }
            //check for last word
            if (!word.isEmpty()) {
                wordCount.merge(word.toString(), 1, Integer::sum);
                totalWords++;
            }
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getMessage());
        }

        stat = new HashSet<>();

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            double percentage = (entry.getValue() * 100.0) / totalWords;
            stat.add(new WordEntry(entry.getKey(), entry.getValue(), percentage));
        }
    }

    public Set<WordEntry> getStat() {
        return stat;
    }

}


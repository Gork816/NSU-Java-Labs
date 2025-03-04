package kg.lab1.main;

import java.util.Objects;

public class WordEntry {
    private final String word;
    private final int count;
    private final double percentage;

    public WordEntry(String word, int count, double percentage) {
        this.word = word;
        this.count = count;
        this.percentage = percentage;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WordEntry other = (WordEntry) obj;
        return word.equals(other.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}


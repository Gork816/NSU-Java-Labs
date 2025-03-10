package kg.lab1.main;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar JavaLab1.jar <file>");
            return;
        }

        String inputFilename = args[0];
        String outputFilename = "output.csv";

        WordCounter wc = new WordCounter();
        wc.processFile(inputFilename);
        CSVWriter.writeToFile(outputFilename, wc.getStat());

        System.out.println("CSV file created: " + outputFilename);
    }
}


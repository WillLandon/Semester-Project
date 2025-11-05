import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class SentimentLexicon {
    private HashMap<String, Double> sentimentScores;

    public SentimentLexicon(String lexiconFile) throws FileNotFoundException {
        this.sentimentScores = loadSentimentScores(lexiconFile);
    }

    private HashMap<String, Double> loadSentimentScores(String lexiconFile) throws FileNotFoundException {
        HashMap<String, Double> sentimentScores = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(lexiconFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] tokens = line.split("\\t");
                    if (tokens.length >= 2) {
                        try {
                            String word = tokens[0].toLowerCase();
                            double score = Double.parseDouble(tokens[1]);
                            sentimentScores.put(word, score);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid sentiment score: " + line);
                        }
                    }
                }
            }
        }
        return sentimentScores;
    }

    public HashMap<String, Double> getSentimentScores() {
        return sentimentScores;
    }

    public Double getScore (String word) {
        return sentimentScores.get(word.toLowerCase());
    }
}

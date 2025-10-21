import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextProcessor {
    //Removes stop words from articles
    private RemoveStopWords removeStopWords;

    /**
     * Constructor that initializes the stop words remover
     * @throws FileNotFoundException if stop words file is not found
     */
    public TextProcessor() throws FileNotFoundException {
        this.removeStopWords = new RemoveStopWords("stopwords.txt");
    }

    /**
     * Analyzes text from a file and return analysis
     * @param file the file to analyze
     * @return TextAnalysis object with statistics
     * @throws FileNotFoundException if the input file is not found
     */
    public TextAnalysis analyzeText(File file) throws FileNotFoundException {
        //Read file content
        String content = readFile(file);
        if (content == null) {
            System.out.println("File not found");
            return null;
        }

        //Remove punctuation and split into words
        ArrayList<String> words = removePunctuation(content);

        //Filter out stop words
        ArrayList<String> filteredWords = removeStopWords.removeStopWords(words);

        //Analyzes the filtered words
        return new TextAnalysis(filteredWords);

    }

    /**
     * Reads the entire content of a file and puts it into a string
     * @param fileName the file to read
     * @return string containing file content, or null if the file is not found
     * @throws FileNotFoundException if file cannot be found/opened
     */
    private String readFile(File fileName) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        //Use Scanner class to read file line by line
        try (Scanner scanner = new Scanner(fileName)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
            }
            return content.toString();
        }
    }

    /**
     * Removes punctuation from text and splits into individual words
     * @param text the input text to process
     * @return ArrayList of words with punctuation removed
     */
    public ArrayList<String> removePunctuation(String text) {
        //Replaces all punctuation with spaces
        text = text.replaceAll("\\p{Punct}", " ");
        //Split text into words using spaces
        String[] wordsArray = text.split(" ");
        ArrayList<String> words = new ArrayList<>();

        //Add words to the list
        for (String word : wordsArray) {
            if (!word.trim().isEmpty()) {
                words.add(word);
            }
        }
        return words;
    }
}

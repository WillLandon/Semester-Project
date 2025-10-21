import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveStopWords {
        //List to store the stop words
        private ArrayList<String> stopWords;


        /**
         * Constructor that loads stop words from the file
         * @param stopWordsFile path to the file containing stop words
         * @throws FileNotFoundException if file is not found
         */
        public RemoveStopWords(String stopWordsFile) throws FileNotFoundException {
                this.stopWords = loadStopWords(stopWordsFile);
        }

        /**
         * Removes stop words from the input of the files
         * @param words ArrayList of words to filter
         * @return ArrayList with stop words removed
         */
        public ArrayList<String> removeStopWords(ArrayList<String> words) {
                ArrayList<String> filtered = new ArrayList<>();
                for (String word : words) {
                        //Keep word if it's not a stop word and not empty
                        if (!stopWords.contains(word.toLowerCase()) && !word.trim().isEmpty()) {
                                filtered.add(word);
                        }
                }
                return filtered;
        }

        /**
         * Loads stop words from file into an ArrayList
         * @param fileName path to the stop words file
         * @return ArrayList containing all stop words
         * @throws FileNotFoundException if file is not found
         */
        private ArrayList<String> loadStopWords(String fileName) throws FileNotFoundException {
                ArrayList<String> stopWords = new ArrayList<>();
                try (Scanner scanner = new Scanner(new File(fileName))) {
                        while (scanner.hasNextLine()) {
                                String word = scanner.nextLine().toLowerCase();
                                if (!word.isEmpty() && !stopWords.contains(word)) {
                                        stopWords.add(word);
                                }
                        }
                }
                return stopWords;
        }
}
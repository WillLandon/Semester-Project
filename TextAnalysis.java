import java.util.ArrayList;
import java.util.HashMap;

public class TextAnalysis {
        //Original list of words after reading them
        private final ArrayList<String> words;
        //Total number of words in each article
        private int totalWords;
        //Number of unique words in each article
        private int uniqueWords;
        //List of unique words found in each article
        private ArrayList<String> uniqueWordList;
        //Frequency counts corresponding to uniqueWordList
        private ArrayList<Integer> frequencyList;
        //Words sorted by frequency
        private ArrayList<String> rankedWords;
        //Frequencies corresponding to rankedWords
        private ArrayList<Integer> rankedFrequencies;

    /**
     * Constructor that performs text analysis on provided words
     * @param words ArrayList of words to analyze
     */
    public TextAnalysis(ArrayList<String> words) {
            this.words = words;
            calculateStatistics();
        }

    /**
     * Calculates several text statistics including word frequencies
     */
    private void calculateStatistics() {
            this.totalWords = words.size();

            //Initialize lists for tracking unique words and their frequencies
            this.uniqueWordList = new ArrayList<>();
            this.frequencyList = new ArrayList<>();

            //Count frequencies of each word
            for (String word : words) {
                int index = uniqueWordList.indexOf(word);
                if (index == -1) {
                    //New word found, add it to unique list with frequency 1
                    uniqueWordList.add(word);
                    frequencyList.add(1);
                } else {
                    //Existing word, increment frequency count
                    int currentFrequency = frequencyList.get(index);
                    frequencyList.set(index, currentFrequency + 1);
                }
            }

            this.uniqueWords = uniqueWordList.size();

            //Sort words by frequency in descending order
            rankedWordsByFrequency();
        }

    /**
     * Ranks words by their frequency using bubble sort
     */
    private void rankedWordsByFrequency() {
            //Create temporary copies of lists for sorting
            ArrayList<String> tempWords = new ArrayList<>(uniqueWordList);
            ArrayList<Integer> tempFrequencies = new ArrayList<>(frequencyList);

            //Bubble sort algorithm
            int n = tempWords.size();
            boolean swapped;

            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                //Last i elements are already in place
                for (int j = 0; j < n - i - 1; j++) {
                    //Compare frequencies
                    if (tempFrequencies.get(j) < tempFrequencies.get(j + 1)) {
                        //Swap frequencies
                        int tempFreq = tempFrequencies.get(j);
                        tempFrequencies.set(j, tempFrequencies.get(j + 1));
                        tempFrequencies.set(j + 1, tempFreq);

                        //Swap corresponding words
                        String tempWord = tempWords.get(j);
                        tempWords.set(j, tempWords.get(j + 1));
                        tempWords.set(j + 1, tempWord);

                        swapped = true;
                    }
                }
                if (!swapped) {
                    break;
                }
            }
            this.rankedWords = tempWords;
            this.rankedFrequencies = tempFrequencies;
            }

              //@Michael
            //Returns the sentiment score of the article
            public double sentScore(ArrayList<String> article, HashMap<String, Double> score) {
                double count = 0;
                for (String word : article) {
                    count += score.get(word);
                }
                return count;
            }


        public void printStatistics() {
            System.out.println("Total words: " + totalWords);
            System.out.println("Unique words: " + uniqueWords);
            System.out.println("Frequencies: " + frequencyList);

            //Displays top 10 words
            System.out.println("Top 10 words by frequency:");
            for (int i = 0; i < Math.min(10, rankedWords.size()); i++) {
                System.out.println((i + 1) + ": " + rankedWords.get(i) + " " + rankedFrequencies.get(i));
            }
        }
    }


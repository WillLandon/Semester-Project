import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String topic = "";

        while (true) {
            System.out.println("Welcome to text analysis using Java!");
            System.out.println("Please select a topic you would like to analyze: ");
            System.out.println("1. headphones");
            System.out.println("2. movies");
            System.out.println("3. roman");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    topic = "headphones";
                    break;
                case 2:
                    topic = "movies";
                    break;
                case 3:
                    topic = "roman";
                    break;
                default:
                    System.out.println("Invalid option!");
            }
            break;
        }

        //Creates TextProcessor instance for text analysis
        TextProcessor processor = new TextProcessor();
        //Get list of files for specified topic
        ArrayList<File> topicFiles = getTopicFiles(topic);

        //Process each file in the topic directory
        for (File file : topicFiles) {
            System.out.println("Processing file: " + file.getName());
            //Analyze text and get results
            TextAnalysis results = processor.analyzeText(file);
            if (results != null) {
                //Print statistics of the text
                results.printStatistics();
            }
            System.out.println("----------");
        }


    }

    /**
     * Returns a list of files for the specific topic
     * @param topic the topic category
     * @return ArrayList of File objects for the topic
     */
    private static ArrayList<File> getTopicFiles(String topic) {
        ArrayList<File> files = new ArrayList<>();
        if (topic.equals("headphones")) {
            files.add(new File("headphones/article1.txt"));
            files.add(new File("headphones/article2.txt"));
            files.add(new File("headphones/article3.txt"));
        } else if (topic.equals("movies")) {
            files.add(new File("movies/RogerEbert.txt"));
            files.add(new File("movies/Woodstocker.txt"));
            files.add(new File("movies/guardian.txt"));
        } else if (topic.equals("roman")) {
            files.add(new File("roman/constantine.txt"));
            files.add(new File("roman/caesar.txt"));
            files.add(new File("roman/caligula.txt"));
        }
        return files;
    }
}

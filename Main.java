import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import edu.stanford.nlp.pipeline.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Sets the topic to process, can be changed to "movies" or "roman"
        String topic = "headphones";

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

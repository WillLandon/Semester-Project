import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class StopWords {
    public static void stopWords(File stopWords) {
        stopWords = new File("stopwords.txt");

        try (Scanner myReader = new Scanner(stopWords)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }
}
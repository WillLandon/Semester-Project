import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StopWords {
    public static void main(String[] args) {
        File stopWords = new File("/Users/loganameres/Desktop/Programming Workshop/Semester-Project/stopwords.txt");

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
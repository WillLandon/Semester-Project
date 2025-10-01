import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Scanner Declaration
        File myObj = new File("/Users/loganameres/Desktop/Topic 1/article1.txt");

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        //Stop words declaration
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

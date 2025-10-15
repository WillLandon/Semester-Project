import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadFile {
    public static void readFile(File file, ArrayList<String> arts) {
        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                arts.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    public ArrayList<String> removePunct(String text) {
        text = text.replaceAll("[^\\sa-zA-Z0-9]", "");
        String[] arr =  text.split("\\s+");
        ArrayList<String> temp= new ArrayList<>(Arrays.asList(arr));
        return temp;
    }
}
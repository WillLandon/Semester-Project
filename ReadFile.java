import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    public static void readFile(File file, ArrayList<String> arts) {
        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    public void removePunct(ArrayList<String> text) {
        for (String string : text) {
        text.get(text.indexOf(string)).replaceAll("[^\\sa-zA-Z0-9]", "");
    }
    }
}
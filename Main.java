import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File head1 = new File("headphones/article1.txt");
        File head2 = new File("headphones/article2.txt");
        File head3 = new File("headphones/article3.txt");
        File movie1 = new File("movies/RogerEbert.txt");
        File movie2 = new File("movies/Woodstocker.txt");
        File movie3 = new File("movies/guardian.txt");
        File roman1 = new File("roman/caesar.txt");
        File roman2 = new File("roman/caligula.txt");
        File roman3 = new File("roman/constantine.txt");
        ArrayList<String> list = new ArrayList<String>();
        ReadFile.readFile(head1);
    }
}

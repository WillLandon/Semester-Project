import java.io.File;
import java.util.ArrayList;

// Driver Class
public class GFG {
    // main function
    public static void createMyFolders(ArrayList<String> topics) {
        // Your list of folders to create
        //Current Address
        String currentDirectory = System.getProperty("user.dir");
        //Creating Folders
        for (String folderName : topics) {
            File folder = new File(currentDirectory + File.separator + folderName);

            }
        }
        public static void createMyFolder(String topic) {
        // Your list of folders to create
        //Current Address
        String currentDirectory = System.getProperty("user.dir");
        //Creating Folders
        File folder = new File(currentDirectory + File.separator + topic);
    }
    public static void createMyFolders(String topic) {
        String currentDirectory = System.getProperty("user.dir");
        File folder = new File(currentDirectory + File.separator + topic);
    }
}
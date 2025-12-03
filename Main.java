import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String topic = "";
        String selectedTopic = "";

        ArrayList<String> topics = new ArrayList<>();
        topics.add("headphones");
        topics.add("movies");
        topics.add("roman");

        GFG.createMyFolders(topics);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to text analysis using Java!");
            System.out.println("1. Select a topic");
            System.out.println("2. Add a topic");
            System.out.println("3. Add an Article");
            int choice = scanner.nextInt();
            ArrayList<File> topicFiles = new ArrayList<>();
            switch (choice) {
                case 1:
                    // Display all topic options
                    System.out.println("\nAvailable topics:");
                    for (int i = 0; i < topics.size(); i++) {
                        System.out.println((i + 1) + ". " + topics.get(i));
                    }
                    System.out.print("Select a topic (1-" + topics.size() + "): ");

                    int topicChoice = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline

                    if (topicChoice >= 0 && topicChoice < topics.size()) {
                        selectedTopic = topics.get(topicChoice);

                        // Get list of files for specified topic
                        topicFiles = topicFiles.getTopicFiles(selectedTopic);

                        if (topicFiles.isEmpty()) {
                            System.out.println("No files found for topic: " + selectedTopic);
                        } else {
                            System.out.println("\nProcessing files for topic: " + selectedTopic);
                            System.out.println("================================");

                            // Create TextProcessor instance for text analysis
                            TextProcessor processor = new TextProcessor();

                            // Process each file in the topic directory
                            for (File file : topicFiles) {
                                if (file.exists()) {
                                    System.out.println("Processing file: " + file.getName());
                                    // Analyze text and get results
                                    TextAnalysis results = processor.analyzeText(file);
                                    if (results != null) {
                                        // Print statistics of the text
                                        results.printStatistics();
                                    }
                                    System.out.println("----------");
                                } else {
                                    System.out.println("File not found: " + file.getPath());
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid topic selection!");
                    }
                    break;

                case 2:
                    System.out.print("Enter new topic name: ");
                    scanner.nextLine();
                    String newTopic = scanner.nextLine().toLowerCase().trim();
                    if (!newTopic.isEmpty() && !topics.contains(newTopic)) {
                        topics.add(newTopic);
                        System.out.println("Topic '" + newTopic + "' added successfully!");
                        GFG.createMyFolders(newTopic);
                    } else if (topics.contains(newTopic)) {
                        System.out.println("Topic already exists!");
                    } else {
                        System.out.println("Invalid topic name!");
                    }
                    break;

                case 3:
                    if (selectedTopic.isEmpty()) {
                        System.out.println("Please select a topic first!");
                        break;
                    }

                    scanner.nextLine(); // Consume leftover newline

                    System.out.print("Enter file name (e.g., 'myfile.txt'): ");
                    String fileName = scanner.nextLine().trim();

                    System.out.print("Enter the text content: ");
                    String fileContent = scanner.nextLine();

                    // Create directory if it doesn't exist
                    File topicDir = new File(selectedTopic);
                    if (!topicDir.exists()) {
                        topicDir.mkdir();
                    }

                    // Create the file with the entered content
                    File newFile = new File(topicDir, fileName);
                    topicFiles.add(fileName);
                    try {
                        java.io.FileWriter writer = new java.io.FileWriter(newFile);
                        writer.write(fileContent);
                        writer.close();
                        System.out.println("File '" + fileName + "' added to topic: " + selectedTopic);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }

    /**
     * Returns a list of files for the specific topic
     * @param topic the topic category
     * @return ArrayList of File objects for the topic
     */
    public static ArrayList<File> getTopicFiles(String topic) {
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

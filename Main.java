import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> topics = new ArrayList<>();
        topics.add("headphones");
        topics.add("movies");
        topics.add("roman");

        while (true) {
            System.out.println("\n========================================");
            System.out.println("Welcome to Text Analysis using Java!");
            System.out.println("========================================");
            System.out.println("1. Select a topic");
            System.out.println("2. Add a new topic");
            System.out.println("3. Add articles to existing topic");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    selectAndAnalyzeTopic(scanner, topics);
                    break;
                case 2:
                    addNewTopic(scanner, topics);
                    break;
                case 3:
                    addArticlesToTopic(scanner, topics);
                    break;
                case 4:
                    System.out.println("Thank you for using Text Analysis!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    /**
     * Allows user to select a topic and analyze its articles
     */
    private static void selectAndAnalyzeTopic(Scanner scanner, ArrayList<String> topics) throws FileNotFoundException {
        System.out.println("\n--- Available Topics ---");
        for (int i = 0; i < topics.size(); i++) {
            System.out.println((i + 1) + ". " + topics.get(i));
        }
        System.out.print("Select a topic (enter number): ");

        int topicChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (topicChoice < 1 || topicChoice > topics.size()) {
            System.out.println("Invalid topic selection!");
            return;
        }

        String selectedTopic = topics.get(topicChoice - 1);
        ArrayList<File> topicFiles = getTopicFiles(selectedTopic);

        if (topicFiles.isEmpty()) {
            System.out.println("No articles found for topic: " + selectedTopic);
            return;
        }

        System.out.println("\n--- Analyzing topic: " + selectedTopic + " ---");
        TextProcessor processor = new TextProcessor();

        for (File file : topicFiles) {
            System.out.println("\n>>> Processing file: " + file.getName());
            TextAnalysis results = processor.analyzeText(file);
            if (results != null) {
                results.printStatistics();
            }
            System.out.println("----------");
        }
    }

    /**
     * Allows user to add a new topic with articles
     */
    private static void addNewTopic(Scanner scanner, ArrayList<String> topics) {
        System.out.print("\nEnter the name of the new topic: ");
        String newTopic = scanner.nextLine().trim().toLowerCase();

        if (newTopic.isEmpty()) {
            System.out.println("Topic name cannot be empty!");
            return;
        }

        if (topics.contains(newTopic)) {
            System.out.println("Topic already exists!");
            return;
        }

        // Create folder for the new topic
        String currentDirectory = System.getProperty("user.dir");
        File topicFolder = new File(currentDirectory + File.separator + newTopic);

        if (!topicFolder.exists()) {
            if (topicFolder.mkdir()) {
                System.out.println("Created folder: " + topicFolder.getAbsolutePath());
            } else {
                System.out.println("Failed to create folder!");
                return;
            }
        }

        topics.add(newTopic);
        System.out.println("Topic '" + newTopic + "' successfully added!");

        // Ask if user wants to add articles now
        System.out.print("Do you want to add articles now? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (response.equals("yes") || response.equals("y")) {
            addArticlesToSpecificTopic(scanner, newTopic);
        }
    }

    /**
     * Allows user to add articles to an existing topic
     */
    private static void addArticlesToTopic(Scanner scanner, ArrayList<String> topics) {
        System.out.println("\n--- Available Topics ---");
        for (int i = 0; i < topics.size(); i++) {
            System.out.println((i + 1) + ". " + topics.get(i));
        }
        System.out.print("Select a topic to add articles to (enter number): ");

        int topicChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (topicChoice < 1 || topicChoice > topics.size()) {
            System.out.println("Invalid topic selection!");
            return;
        }

        String selectedTopic = topics.get(topicChoice - 1);
        addArticlesToSpecificTopic(scanner, selectedTopic);
    }

    /**
     * Helper method to add articles to a specific topic
     */
    private static void addArticlesToSpecificTopic(Scanner scanner, String topic) {
        System.out.print("\nHow many articles do you want to add? ");
        int numArticles = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numArticles; i++) {
            System.out.println("\n--- Article " + (i + 1) + " ---");
            System.out.print("Enter the filename (e.g., article1.txt): ");
            String filename = scanner.nextLine().trim();

            // Create the file path
            File articleFile = new File(topic + File.separator + filename);

            // Get the article content from user
            System.out.println("Enter the article text (type 'END' on a new line when finished):");
            StringBuilder content = new StringBuilder();

            while (true) {
                String line = scanner.nextLine();
                if (line.equals("END")) {
                    break;
                }
                content.append(line).append("\n");
            }

            // Write content to file
            try (FileWriter writer = new FileWriter(articleFile)) {
                writer.write(content.toString());
                System.out.println("Article saved successfully: " + articleFile.getPath());
            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }
        }

        System.out.println("\nAll articles added to topic '" + topic + "'!");
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
        } else {
            // For new topics, scan the directory for all .txt files
            String currentDirectory = System.getProperty("user.dir");
            File topicFolder = new File(currentDirectory + File.separator + topic);

            if (topicFolder.exists() && topicFolder.isDirectory()) {
                File[] allFiles = topicFolder.listFiles();
                if (allFiles != null) {
                    for (File file : allFiles) {
                        if (file.isFile() && file.getName().endsWith(".txt")) {
                            files.add(file);
                        }
                    }
                }
            }
        }

        return files;
    }
}
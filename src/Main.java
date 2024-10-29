import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Write a program that reads words from a text file
 * Displays all the words (duplicates allowed) in ascending alphabetical order
 * The words must start with a letter.
 * The text file is passed as a command-line argument
 */

public class Main {
    public static void main(String[] args) {
        try {
            String path = getFileFromUser();
            if (getFileContent(path).isEmpty()) {
                System.out.println("The given file is empty. Exiting...");
                return;
            }
            displaySortedWords(getFileContent(path));
        } catch (FileNotFoundException _) {
            System.out.println("File not found. Exiting...");
        }
    }

    private static String getFileFromUser() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter a file path:");
            return Paths.get(scanner.nextLine()).toString();
        }
    }

    private static List<String> getFileContent(String path) throws FileNotFoundException {
        List<String> words = new ArrayList<>();

        try (Scanner reader = new Scanner(new File(path))) {
            while (reader.hasNext()) {
                String word = reader.next();
                if (Character.isLetter(word.charAt(0))) {
                    words.add(word);
                }
            }
        }

        return words;
    }

    private static void displaySortedWords(List<String> words) {
        Collections.sort(words);
        for (String word : words) {
            System.out.println(word);
        }
    }
}

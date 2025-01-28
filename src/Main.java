import javax.lang.model.SourceVersion;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Write a program that reads a Java source-code file
 * Reports the number of keywords (including null, true, and false) in the file
 * If a keyword is in a comment or in a string, don’t count it
 * Pass the Java file name from the command line. (Hint: Create a set to store all the Java keywords.)
 */
public class Main {
    public static void main(String[] args) {
        try {
            String path = getFileFromUser();
            List<String> keywords = getFileContent(path);
            if (keywords.isEmpty()) {
                System.out.println("The given file is empty. Exiting...");
                return;
            }
            System.out.println("Number of keywords in the file are: " + keywords.size());

            print(keywords);
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
        List<String> keywords = new ArrayList<>();
        StringBuilder fileContent = new StringBuilder();

        try (Scanner reader = new Scanner(new File(path))) {
            while (reader.hasNextLine()) {
                fileContent.append(reader.nextLine()).append("\n");
            }
        }

        try (Scanner reader = new Scanner(fileContent.toString())) {
            while (reader.hasNext()) {
                String word = reader.next().strip().replace("()", "");
                if (Character.isLetter(word.charAt(0)) && isJavaKeyword(word)) {
                    keywords.add(word);
                }
            }
        }

        return keywords;
    }

    private static boolean isJavaKeyword(String word) {
        return SourceVersion.isKeyword(word);
    }

    private static void print(List<String> words) {
        for (String word : words) {
            System.out.println(word);
        }
    }
}
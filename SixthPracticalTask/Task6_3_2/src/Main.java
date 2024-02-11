import java.io.*;

public class Main {
    public static void main(String[] args) {
        String utf8FilePath = "C://Users/goodd/IdeaProjects/Java-programming-ITMO/SixthPracticalTask/Task6_3_2/src/file_utf8.txt";
        String windows1251FilePath = "C://Users/goodd/IdeaProjects/Java-programming-ITMO/SixthPracticalTask/Task6_3_2/src/file_windows1251.txt";

        System.out.println("Reading file encoded in UTF-8:");
        readFile(utf8FilePath, "UTF-8");

        System.out.println("\nReading file encoded in WINDOWS-1251:");
        readFile(windows1251FilePath, "windows-1251");
    }

    private static void readFile(String fileName, String charsetName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), charsetName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
package repositories;
import java.util.List;
import java.io.*;

public class FileLoader {
    // Loads data from a file into a list
    public static List<String> loadFile(String fileName) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + fileName);
        }
        return data;
    }
}

package codes.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
    public List<String> readLines(String filename) throws IOException {
        return Files.readAllLines(Paths.get(filename));
    }

    public void writeLines(String filename, List<String> lines) throws IOException {
        Files.write(Paths.get(filename), lines);
    }
}

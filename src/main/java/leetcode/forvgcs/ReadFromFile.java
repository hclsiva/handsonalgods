package leetcode.forvgcs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFromFile {
    public void readFileContentsAfterRemovingEmptyLines(String fileName){
        try {
            StringBuffer buffer = new StringBuffer();
            Files.readAllLines(Path.of(fileName)).stream()
                    .filter(s -> !s.isEmpty() || !s.isBlank())
                    .forEach(buffer::append);
            System.out.println(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReadFromFile readFromFile = new ReadFromFile();
        readFromFile.readFileContentsAfterRemovingEmptyLines("fileWithEmptyLines.txt");
    }
}

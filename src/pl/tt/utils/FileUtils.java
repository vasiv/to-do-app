package pl.tt.utils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    public static void createFolder(Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                System.out.println("Could not create folder at specified path: " + path);
                e.printStackTrace();
            }
        }
    }

    public static void createFile(Path path, String content) {
        File file = new File(path.toUri());
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            outputStreamWriter.write(content);
        } catch (IOException e) {
            System.out.println("Could not write to the file with specified path: " + path);
            e.printStackTrace();
        }
    }

    public static String readFileAsString(Path path) {
        String content = "";
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                content += currentLine + "\n";
            }
        } catch (IOException ex) {
            System.out.println("Could not read file as string from path: " + path);
            ex.printStackTrace();
        }
        return content;
    }
}

package org.example.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {
    public static void writeJSONToFile(String fileName, String prettyJson) {
        try (FileWriter writer = new FileWriter(fileName, false))
        {
            writer.write(prettyJson);
            writer.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static StringBuffer writeXMLToString(HttpURLConnection connection) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String inputLine = null;
        StringBuffer response = new StringBuffer();

        while (true) {
            try {
                if (!((inputLine = in.readLine()) != null)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.append(inputLine);
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public static void createFolderForFiles() {
        File folder = new File("src/main/files");
        if (!(folder.exists())) {
            folder.mkdir();
        }
    }

    public static void createFile(String fileName) {
        Path newFilePath = Paths.get(fileName);
        try {
            Files.createFile(newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

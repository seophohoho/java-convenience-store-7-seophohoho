package store.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String basePath = "./src/main/resources/";

    public static List<String> readLine(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File (basePath+filename);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String line;

        br.readLine();
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        return lines;
    }
}

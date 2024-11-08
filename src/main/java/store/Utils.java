package store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Utils {
    private static final String basePath = "./src/main/resources/";

    public static BufferedReader readFile(String filename) throws FileNotFoundException {
        File file = new File (basePath+filename);
        FileReader fileReader = new FileReader(file);

        return new BufferedReader(fileReader);
    }
}

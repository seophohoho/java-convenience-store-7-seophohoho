package store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Utils {
    private static final String basePath = "./src/main/resources/";

    //나중에 try-catch로 FileNotFoundException 처리도 좀 해야 할듯.
    public static BufferedReader readFile(String filename) throws FileNotFoundException {
        File file = new File (basePath+filename);
        FileReader fileReader = new FileReader(file);

        return new BufferedReader(fileReader);
    }

    public static String[] separateStr(String str,String separator) {
        return str.split(separator);
    }

    public static String removeFirstAndLastStr(String str){
        return str.substring(1,str.length()-1);
    }
}

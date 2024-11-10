package store.util;

public class StringUtil {
    public static final String SEPARATOR_COMMA = ",";
    public static final String SEPARATOR_HYPHEN = "-";

    public static String[] separate(String str,String separator) {
        return str.split(separator);
    }

    public static String removeFirstAndLast(String str){
        return str.substring(1,str.length()-1);
    }
}

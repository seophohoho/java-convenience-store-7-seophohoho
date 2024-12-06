package store.utils;

import java.util.List;

public class StringUtil {
    public static final String DELIMITER_COMMA = ",";
    public static final String DELIMITER_HYPEN = "-";

    public static List<String> separate(String str, String delimiter) {
        List<String> ret = List.of(str.split(delimiter));
        return ret;
    }

    public static String trimFirstAndLast(String str) {
        if (str == null || str.length() <= 1) {
            return "";
        }
        return str.substring(1, str.length() - 1);
    }
}

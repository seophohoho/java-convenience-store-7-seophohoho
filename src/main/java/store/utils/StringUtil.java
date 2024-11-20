package store.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    public static List<String> separate(String str, String delimiter){
        List<String> ret = List.of(str.split(delimiter));
        return ret;
    }
}

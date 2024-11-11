package store.util;

import java.text.NumberFormat;
import java.util.Locale;

public class StringUtil {
    public static final String SEPARATOR_COMMA = ",";
    public static final String SEPARATOR_HYPHEN = "-";

    public static String[] separate(String str,String separator) {
        return str.split(separator);
    }

    public static String removeFirstAndLast(String str){
        return str.substring(1,str.length()-1);
    }

    public static String priceToStr(int price) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.KOREA);
        return formatter.format(price);
    }
}

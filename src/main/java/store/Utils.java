package store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import store.model.Promotion;

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

    public static LocalDateTime getDateTimeNow(){
        return DateTimes.now();
    }

    public static LocalDateTime strToLocalDateTime(String dateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateStr, formatter).atStartOfDay();
    }

    public static Promotion getPromotion(String name){
        Promotion ret = Promotion.TWO_PLUS_ONE;
        for(Promotion promotion : Promotion.values()){
            if(promotion.getName().equals(name)){
                ret = promotion;
            }
        }
        return ret;
    }
}

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

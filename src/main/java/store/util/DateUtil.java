package store.util;

import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static LocalDateTime getDateTimeNow(){
        return DateTimes.now();
    }

    public static LocalDateTime strToLocalDateTime(String dateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateStr, formatter).atStartOfDay();
    }
}

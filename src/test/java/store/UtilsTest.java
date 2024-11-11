package store;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.model.Promotion;
import store.model.Store;
import store.util.DateUtil;

public class UtilsTest {
    @Test
    @DisplayName("현재 시간 반환 테스트")
    void testGetNow(){
        assertThat(DateUtil.getDateTimeNow()).hasYear(2024).hasMonth(Month.NOVEMBER).hasDayOfMonth(10);
    }

    @Test
    @DisplayName("문자열을 LocalDateTime 변환 테스트")
    void testStrToLocalDateTime() {
        assertThat(DateUtil.strToLocalDateTime("2024-11-10")).isEqualTo(LocalDateTime.of(2024, 11, 10, 0, 0));
        assertThat(DateUtil.strToLocalDateTime("2024-12-25")).isEqualTo(LocalDateTime.of(2024, 12, 25, 0, 0));
    }

}

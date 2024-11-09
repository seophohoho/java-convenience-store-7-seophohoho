package store;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.Month;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    @Test
    @DisplayName("현재 시간 반환 테스트")
    void testGetNow(){
        assertThat(Utils.getDateTimeNow()).hasYear(2024).hasMonth(Month.NOVEMBER).hasDayOfMonth(10);
    }

}

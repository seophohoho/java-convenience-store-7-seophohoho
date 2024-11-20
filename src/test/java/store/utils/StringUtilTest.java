package store.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilTest {
    @Test
    @DisplayName("구분자 기준 문자열 분리 테스트")
    void testSeparate(){
        List<String> expected = List.of("반짝할인","1","1","2024-11-01","2024-11-30");

        assertEquals(expected,StringUtil.separate("반짝할인,1,1,2024-11-01,2024-11-30",","));
    }
}

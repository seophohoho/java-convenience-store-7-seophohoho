package store.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileUtilTest {
    private static final String TEST_FILENAME = "promotions.md";
    @Test
    @DisplayName("파일 줄 읽기 테스트")
    void testReadlineFile() throws IOException {
        List<String> actual = new ArrayList<>();
        actual.add("탄산2+1,2,1,2024-01-01,2024-12-31");
        actual.add("MD추천상품,1,1,2024-01-01,2024-12-31");
        actual.add("반짝할인,1,1,2024-11-01,2024-11-30");

        assertEquals(FileUtil.readLine(TEST_FILENAME),actual);
    }
}

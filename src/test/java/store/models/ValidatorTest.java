package store.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    @DisplayName("주문 입력 체크 - 올바르지 않은 형식으로 입력했는가")
    void order_check_invalid_form() {
        //Given
        Validator validator = new Validator();
        ErrorGroup error = ErrorGroup.INVALID_FORM;
        List<String> cases = new ArrayList<>();

        cases.add("[콜라-3],[에너지바-5");
        cases.add("콜라-3]");
        cases.add("[!dklsfkdslfksdl--3]");
        cases.add("콜라-3,");
        cases.add("[콜라-3],[에너지바-5],");
        cases.add("[콜라-3],[");
        cases.add("[콜라-3],[에너지바]");
        cases.add("[콜라-3],[에너지바-에너지바]");
        cases.add("[콜라-3],[123123-에너지바]");
        cases.add("[콜라-3],[감자칩-012]");
        cases.add("[콜라-3],,[에너지바-5]");

        for (String testCase : cases) {
            ErrorGroup errorGroup = validator.order(testCase);
            assertEquals(errorGroup, error, "퉤:" + testCase);
        }

    }

    @Test
    @DisplayName("주문 입력 체크 - 올바른 형식으로 입력했는가")
    void order_check_valid_form() {
        //Given
        Validator validator = new Validator();
        ErrorGroup error = ErrorGroup.EMPTY;
        List<String> cases = new ArrayList<>();

        cases.add("[콜라-3],[에너지바-5]");
        cases.add("[콜라-3]");
        cases.add("[비타500-3]");
        cases.add("[2%-3]");
        cases.add("[TestJuice-3]");

        for (String testCase : cases) {
            ErrorGroup errorGroup = validator.order(testCase);
            assertEquals(errorGroup, error, "퉤:" + testCase);
        }

    }


}

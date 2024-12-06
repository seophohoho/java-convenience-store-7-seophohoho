//package store.models;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import store.Controller;
//import store.Validator;
//import store.dto.ErrorGroup;
//import store.utils.StringUtil;
//
//public class ValidatorTest {
//    private Controller controller;
//    private Validator validator;
//
//    @BeforeEach
//    void init() throws IOException {
//        this.controller = new Controller();
//        this.validator = new Validator();
//
//        controller.init();
//    }
//
//    @Test
//    @DisplayName("주문 입력 체크 - 올바르지 않은 형식으로 입력했는가")
//    void order_check_invalid_form() {
//        //Given
//        Validator validator = new Validator();
//        ErrorGroup error = ErrorGroup.INVALID_FORM;
//        List<String> cases = new ArrayList<>();
//
//        cases.add("[콜라-3],[에너지바-5");
//        cases.add("콜라-3]");
//        cases.add("[!dklsfkdslfksdl--3]");
//        cases.add("콜라-3,");
//        cases.add("[콜라-3],[에너지바-5],");
//        cases.add("[콜라-3],[");
//        cases.add("[콜라-3],[에너지바]");
//        cases.add("[콜라-3],[에너지바-에너지바]");
//        cases.add("[콜라-3],[123123-에너지바]");
//        cases.add("[콜라-3],[감자칩-012]");
//        cases.add("[콜라-3],,[에너지바-5]");
//
//        for (String testCase : cases) {
//            ErrorGroup errorGroup = validator.order(testCase);
//            assertEquals(errorGroup, error, "퉤:" + testCase);
//        }
//
//    }
//
//    @Test
//    @DisplayName("주문 입력 체크 - 올바른 형식으로 입력했는가")
//    void order_check_valid_form() {
//        //Given
//        Validator validator = new Validator();
//        ErrorGroup error = ErrorGroup.EMPTY;
//        List<String> cases = new ArrayList<>();
//
//        cases.add("[콜라-3],[에너지바-5]");
//        cases.add("[콜라-3]");
//        cases.add("[비타500-3]");
//        cases.add("[2%-3]");
//        cases.add("[TestJuice-3]");
//
//        for (String testCase : cases) {
//            ErrorGroup errorGroup = validator.order(testCase);
//            assertEquals(errorGroup, error, "퉤:" + testCase);
//        }
//
//    }
//
//    @Test
//    @DisplayName("주문 입력 체크 - 존재하는 상품인가?")
//    void order_check_exist_product() {
//        boolean expected_1 = this.validator.hasProduct(
//                StringUtil.separate("[콜라-3],[에너지바-5]", StringUtil.DELIMITER_COMMA));
//        boolean expected_2 = this.validator.hasProduct(
//                StringUtil.separate("[콜라-3],[미에로하이바-5]", StringUtil.DELIMITER_COMMA));
//
//        assertEquals(expected_1, true);
//        assertEquals(expected_2, false);
//    }
//}

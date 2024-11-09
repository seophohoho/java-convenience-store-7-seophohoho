package store;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import store.model.Validator;


public class ValidatorTest {
    @Test
    @DisplayName("물품 주문 입력 검증 테스트_1개의 주문에 대해서")
    void testOrderValidate_1(){
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.orderValidate(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate(" "))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate("콜라-"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate("콜라"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate("콜라-10"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate("[콜라-10],,"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate("[콜라-10],"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate(" [콜라-10]"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate(" [콜라-10] "))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate("[콜라-10"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate("[콜라-dwdwdw10]"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate("[콜라-dwdwdw10] "))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate("[콜라-dwdwdw10 ]"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate("[콜라-01]"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("물품 주문 입력 검증 테스트_2개 이상의 주문에 대해서")
    void testOrderValidate_2(){
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.orderValidate("[콜라-10],[사이다-10"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate("[콜라-10],사이다-10"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.orderValidate("[콜라-10],[사이다-10],[비타민워터]"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("물품 주문 올바른 입력 테스트")
    void testOrderValidate_Correct(){
        Validator validator = new Validator();

        assertThat(validator.orderValidate("[water-10]")).isTrue();
        assertThat(validator.orderValidate("[콜라-10]")).isTrue();
        assertThat(validator.orderValidate("[콜라-10],[사이다-10]")).isTrue();
        assertThat(validator.orderValidate("[콜라-10],[사이다-10],[물-3]")).isTrue();
    }
}

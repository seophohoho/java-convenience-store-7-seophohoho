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

    @Test
    @DisplayName("Promotion 정보 얻기 테스트")
    void testGetPromotion() throws IOException {
        Store store = new Store();
        store.initPromotion();

        assertThat(Utils.getPromotion("탄산2+1")).isEqualTo(Promotion.TWO_PLUS_ONE);
        assertThat(Utils.getPromotion("MD추천상품")).isEqualTo(Promotion.MD_RECOMMEND);
        assertThat(Utils.getPromotion("반짝할인")).isEqualTo(Promotion.SHINY_SALE);
    }

}

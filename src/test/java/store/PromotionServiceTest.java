package store;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.model.Order;
import store.model.Promotion;
import store.model.Store;
import store.service.PromotionService;

public class PromotionServiceTest {
    @Test
    @DisplayName("추가 혜택을 받을 수 있는지 테스트")
    void isBenefit() throws IOException {
        Store store = new Store();
        PromotionService promotionService = new PromotionService(store);
        store.initPromotion();
        store.initProduct();

        Promotion promotion = Promotion.TWO_PLUS_ONE;
        System.out.print(promotion.getBuy());

        assertEquals(1,promotionService.calculatePromotionBenefit(new Order("콜라",10)));

    }
}

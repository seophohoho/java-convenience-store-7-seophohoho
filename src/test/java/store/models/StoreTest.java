package store.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StoreTest {
    @Test
    @DisplayName("프로모션 정보 저장 테스트")
    void setPromotionInfoTest(){
        Store store = new Store();
        Map<String,Promotion> expected = new HashMap<>();

        expected.put("탄산2+1",new Promotion("탄산2+1",2,1,"2024-01-01","2024-12-31"));
        expected.put("MD추천상품",new Promotion("MD추천상품",1,1,"2024-01-01","2024-12-31"));
        expected.put("반짝할인",new Promotion("반짝할인",1,1,"2024-11-01","2024-11-30"));

        Promotion promotion1 = store.createPromotion(List.of("탄산2+1","2","1","2024-01-01","2024-12-31"));
        Promotion promotion2 = store.createPromotion(List.of("MD추천상품","1","1","2024-01-01","2024-12-31"));
        Promotion promotion3 = store.createPromotion(List.of("반짝할인","1","1","2024-11-01","2024-11-30"));

        store.setPromotion(promotion1.getName(),promotion1);
        store.setPromotion(promotion2.getName(),promotion2);
        store.setPromotion(promotion3.getName(),promotion3);

        assertThat(store.promotions.get("탄산2+1"))
                .usingRecursiveComparison()
                .isEqualTo(expected.get("탄산2+1"));

        assertThat(store.promotions.get("MD추천상품"))
                .usingRecursiveComparison()
                .isEqualTo(expected.get("MD추천상품"));

        assertThat(store.promotions.get("반짝할인"))
                .usingRecursiveComparison()
                .isEqualTo(expected.get("반짝할인"));
    }
}

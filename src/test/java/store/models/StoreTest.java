package store.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.dto.ProductDefault;
import store.dto.ProductPromotion;
import store.dto.Promotion;
import store.repository.PromotionRepository;
import store.repository.StoreRepository;

public class StoreTest {
    @Test
    @DisplayName("프로모션 정보 저장 테스트")
    void test_set_promotion_info() {
        PromotionRepository promotionRepository = new PromotionRepository();
        Map<String, Promotion> expected = new HashMap<>();

        expected.put("탄산2+1", new Promotion("탄산2+1", 2, 1, "2024-01-01", "2024-12-31"));
        expected.put("MD추천상품", new Promotion("MD추천상품", 1, 1, "2024-01-01", "2024-12-31"));
        expected.put("반짝할인", new Promotion("반짝할인", 1, 1, "2024-11-01", "2024-11-30"));

        Promotion promotion1 = promotionRepository.createPromotion(
                List.of("탄산2+1", "2", "1", "2024-01-01", "2024-12-31"));
        Promotion promotion2 = promotionRepository.createPromotion(
                List.of("MD추천상품", "1", "1", "2024-01-01", "2024-12-31"));
        Promotion promotion3 = promotionRepository.createPromotion(
                List.of("반짝할인", "1", "1", "2024-11-01", "2024-11-30"));

        promotionRepository.setPromotion(promotion1.getName(), promotion1);
        promotionRepository.setPromotion(promotion2.getName(), promotion2);
        promotionRepository.setPromotion(promotion3.getName(), promotion3);

        assertThat(promotionRepository.getPromotion("탄산2+1"))
                .usingRecursiveComparison()
                .isEqualTo(expected.get("탄산2+1"));

        assertThat(promotionRepository.getPromotion("MD추천상품"))
                .usingRecursiveComparison()
                .isEqualTo(expected.get("MD추천상품"));

        assertThat(promotionRepository.getPromotion("반짝할인"))
                .usingRecursiveComparison()
                .isEqualTo(expected.get("반짝할인"));
    }

    @Test
    @DisplayName("제품 저장 테스트 - 특정 제품이 프로모션과 일반을 가지는 경우")
    void test_set_product_info_0() {
        StoreRepository storeRepository = new StoreRepository();
        Map<String, ProductDefault> expectedDefaultProduct = new LinkedHashMap<>();
        Map<String, ProductPromotion> expectedPromotionProduct = new LinkedHashMap<>();

        expectedDefaultProduct.put("콜라", new ProductDefault("콜라", 1000, 10));
        expectedPromotionProduct.put("콜라", new ProductPromotion("콜라", 1000, 10, "탄산2+1"));

        storeRepository.addDefaultOrPromotionProducts(List.of("콜라", "1000", "10", "탄산2+1"));
        storeRepository.addDefaultOrPromotionProducts(List.of("콜라", "1000", "10", "null"));

        assertThat(storeRepository.getDefaultProduct("콜라"))
                .usingRecursiveComparison()
                .isEqualTo(expectedDefaultProduct.get("콜라"));

        assertThat(storeRepository.getPromotionProduct("콜라"))
                .usingRecursiveComparison()
                .isEqualTo(expectedPromotionProduct.get("콜라"));
    }

    @Test
    @DisplayName("제품 저장 테스트 - 특정 제품이 프로모션만 가지는 경우")
    void test_set_product_info_1() {
        StoreRepository storeRepository = new StoreRepository();
        Map<String, ProductDefault> expectedDefaultProduct = new LinkedHashMap<>();
        Map<String, ProductPromotion> expectedPromotionProduct = new LinkedHashMap<>();

        expectedDefaultProduct.put("오렌지주스", new ProductDefault("오렌지주스", 1800, 0));
        expectedPromotionProduct.put("오렌지주스", new ProductPromotion("오렌지주스", 1800, 9, "MD추천상품"));

        storeRepository.addDefaultOrPromotionProducts(List.of("오렌지주스", "1800", "9", "MD추천상품"));

        assertThat(storeRepository.getDefaultProduct("오렌지주스"))
                .usingRecursiveComparison()
                .isEqualTo(expectedDefaultProduct.get("오렌지주스"));

        assertThat(storeRepository.getPromotionProduct("오렌지주스"))
                .usingRecursiveComparison()
                .isEqualTo(expectedPromotionProduct.get("오렌지주스"));
    }

}

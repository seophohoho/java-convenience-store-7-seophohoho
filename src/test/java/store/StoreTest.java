//package store;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import store.model.Order;
//import store.model.Product;
//import store.model.Promotion;
//import store.model.Store;
//import store.service.OrderService;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class StoreTest {
//    Map<String, Product> expectedDefault = new HashMap<>();
//    Map<String, Product> expectedPromotion = new HashMap<>();
//
//    @Test
//    @DisplayName("products.md 파일을 읽고, product 객체 생성 테스트")
//    void testProducts() throws IOException {
//        Store store = new Store();
//        store.initProduct();
//
//        setExpectedDefaultOrPromotion();
//
//        for (Map.Entry<String, Product> entry : expectedDefault.entrySet()) {
//            String key = entry.getKey();
//            Product expectedProduct = entry.getValue();
//            Product actualProduct = store.getProductDefault().get(key);
//
//            assertThat(actualProduct).isNotNull();
//            assertThat(actualProduct.getName()).isEqualTo(expectedProduct.getName());
//            assertThat(actualProduct.getPrice()).isEqualTo(expectedProduct.getPrice());
//            assertThat(actualProduct.getQuantity()).isEqualTo(expectedProduct.getQuantity());
//            assertThat(actualProduct.getPromotion()).isEqualTo(expectedProduct.getPromotion());
//        }
//
//        for (Map.Entry<String, Product> entry : expectedPromotion.entrySet()) {
//            String key = entry.getKey();
//            Product expectedProduct = entry.getValue();
//            Product actualProduct = store.getProductPromotion().get(key);
//
//            assertThat(actualProduct).isNotNull();
//            assertThat(actualProduct.getName()).isEqualTo(expectedProduct.getName());
//            assertThat(actualProduct.getPrice()).isEqualTo(expectedProduct.getPrice());
//            assertThat(actualProduct.getQuantity()).isEqualTo(expectedProduct.getQuantity());
//            assertThat(actualProduct.getPromotion()).isEqualTo(expectedProduct.getPromotion());
//        }
//    }
//
//    @Test
//    @DisplayName("promotion.md 파일을 읽고, promotion 저장 테스트")
//    void testPromotion() throws IOException {
//        Store store = new Store();
//        store.initPromotion();
//        List<List<Object>> expected = List.of(
//                List.of("탄산2+1",2,1,"2024-01-01","2024-12-31"),
//                List.of("MD추천상품",1,1,"2024-01-01","2024-12-31"),
//                List.of("반짝할인",1,1,"2024-11-01","2024-11-30")
//        );
//
//        int idx=0;
//        for(Promotion promotion: Promotion.values()){
//            assertEquals(expected.get(idx).get(0),promotion.getName());
//            assertEquals(expected.get(idx).get(1),promotion.getBuy());
//            assertEquals(expected.get(idx).get(2),promotion.getGet());
//            assertEquals(expected.get(idx).get(3),promotion.getStart());
//            assertEquals(expected.get(idx).get(4),promotion.getEnd());
//            idx++;
//        }
//    }
//
//    @Test
//    @DisplayName("존재하는 상품인지 테스트")
//    void testIsExistProduct() throws IOException {
//        Store store = new Store();
//
//        store.initProduct();
//        setExpectedDefaultOrPromotion();
//
//        assertThat(store.isExistProduct("콜라")).isTrue();
//        assertThat(store.isExistProduct("물")).isTrue();
//        assertThat(store.isExistProduct("사이다")).isTrue();
//        assertThat(store.isExistProduct("정식도시락")).isTrue();
//        assertThat(store.isExistProduct("코카콜라 제로")).isFalse();
//        assertThat(store.isExistProduct("뿌링클")).isFalse();
//    }
//
//    @Test
//    @DisplayName("해당 상품의 재고 초과 테스트")
//    void testIsExceedQuantity() throws IOException {
//        Store store = new Store();
//
//        store.initProduct();
//        setExpectedDefaultOrPromotion();
//
//        assertThat(store.isExceedQuantity("콜라",200)).isTrue();
//        assertThat(store.isExceedQuantity("콜라",20)).isFalse();
//        assertThat(store.isExceedQuantity("콜라",5)).isFalse();
//
//        assertThat(store.isExceedQuantity("사이다",16)).isTrue();
//        assertThat(store.isExceedQuantity("콜라",10)).isFalse();
//        assertThat(store.isExceedQuantity("콜라",7)).isFalse();
//    }
//
//    @Test
//    @DisplayName("오늘 날짜가 특정 기간에 속해 있는지 확인 테스트")
//    void testIsTodayPromotionPeriod() throws IOException {
//        Store store = new Store();
//        store.initPromotion();
//
//        assertThat(store.isTodayPromotionPeriod(Promotion.TWO_PLUS_ONE.getStart(),Promotion.TWO_PLUS_ONE.getEnd())).isTrue();
//        assertThat(store.isTodayPromotionPeriod("2023-10-10","2023-12-25")).isFalse();
//    }
//
//    private void setExpectedDefaultOrPromotion(){
//        expectedPromotion.put("콜라",new Product("콜라",1000,10,"탄산2+1"));
//        expectedDefault.put("콜라",new Product("콜라",1000,10,"null"));
//
//        expectedPromotion.put("사이다",new Product("사이다",1000,8,"탄산2+1"));
//        expectedDefault.put("사이다",new Product("사이다",1000,7,"null"));
//
//        expectedPromotion.put("오렌지주스",new Product("오렌지주스",1800,9,"MD추천상품"));
//        expectedDefault.put("오렌지주스",new Product("오렌지주스",1800,0,"null"));
//
//        expectedPromotion.put("탄산수",new Product("탄산수",1200,5,"탄산2+1"));
//        expectedDefault.put("탄산수",new Product("탄산수",1200,0,"null"));
//
//        expectedDefault.put("물",new Product("물",500,10,"null"));
//
//        expectedDefault.put("비타민워터",new Product("비타민워터",1500,6,"null"));
//
//        expectedPromotion.put("감자칩",new Product("감자칩",1500,5,"반짝할인"));
//        expectedDefault.put("감자칩",new Product("감자칩",1500,5,"null"));
//
//        expectedPromotion.put("초코바",new Product("초코바",1200,5,"MD추천상품"));
//        expectedDefault.put("초코바",new Product("초코바",1200,5,"null"));
//
//        expectedDefault.put("에너지바",new Product("에너지바",2000,5,"null"));
//
//        expectedDefault.put("정식도시락",new Product("정식도시락",6400,8,"null"));
//
//        expectedPromotion.put("컵라면",new Product("컵라면",1700,1,"MD추천상품"));
//        expectedDefault.put("컵라면",new Product("컵라면",1700,10,"null"));
//    }
//}

package store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.model.Product;
import store.model.Store;
import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest {
    @Test
    @DisplayName("products.md 파일을 읽고, product 객체 생성 테스트")
    void testProducts() throws IOException {
        Store store = new Store();

        List<Product> expected = new ArrayList<>();
        expected.add(new Product("콜라",1000,10,"탄산2+1"));
        expected.add(new Product("콜라",1000,10,"null"));
        expected.add(new Product("사이다",1000,8,"탄산2+1"));
        expected.add(new Product("사이다",1000,7,"null"));
        expected.add(new Product("오렌지주스",1800,9,"MD추천상품"));
        expected.add(new Product("탄산수",1200,5,"탄산2+1"));
        expected.add(new Product("물",500,10,"null"));
        expected.add(new Product("비타민워터",1500,6,"null"));
        expected.add(new Product("감자칩",1500,5,"반짝할인"));
        expected.add(new Product("감자칩",1500,5,"null"));
        expected.add(new Product("초코바",1200,5,"MD추천상품"));
        expected.add(new Product("초코바",1200,5,"null"));
        expected.add(new Product("에너지바",2000,5,"null"));
        expected.add(new Product("정식도시락",6400,8,"null"));
        expected.add(new Product("컵라면",1700,1,"MD추천상품"));
        expected.add(new Product("컵라면",1700,10,"null"));

        assertThat(store.getProducts())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyElementsOf(expected);

    }
}

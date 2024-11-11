package store;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.model.Order;
import store.model.Store;
import store.service.OrderService;

public class OrderServiceTest {
    @Test
    @DisplayName("주문 목록 저장하기 테스트")
    void testTakeOrder(){
        Store store = new Store();
        OrderService service = new OrderService(store);
        List<Order> expected = new ArrayList<>();

        service.takeOrder("[콜라-3],[에너지바-5],[물-3]");

        expected.add(new Order("콜라",3));
        expected.add(new Order("에너지바",5));
        expected.add(new Order("물",3));

        assertThat(service.getOrders())
                .usingRecursiveFieldByFieldElementComparator()
                .isEqualTo(expected);

    }
}

package store.models;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.dto.Order;
import store.repository.OrderRepository;
import store.service.OrderService;

public class OrderTest {
    @Test
    @DisplayName("주문 저장 테스트")
    void test_add_orders() {
        OrderRepository orderRepository = new OrderRepository();
        OrderService orderService = new OrderService(orderRepository);

        List<Order> expected = new ArrayList<>();
        expected.add(new Order("콜라", 10));
        expected.add(new Order("사이다", 5));

        orderService.receiveOrder(List.of("콜라", "10"));
        orderService.receiveOrder(List.of("사이다", "5"));

        assertThat(orderRepository.getOrders())
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}

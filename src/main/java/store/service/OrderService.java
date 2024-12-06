package store.service;

import java.util.List;
import store.repository.OrderRepository;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void receiveOrder(List<String> info) {
        String product = info.get(0);
        int quantity = Integer.parseInt(info.get(1));

        orderRepository.addOrder(product, quantity);
    }
}

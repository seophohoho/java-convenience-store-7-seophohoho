package store.repository;

import java.util.ArrayList;
import java.util.List;
import store.dto.Order;

public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(String product, int quantity) {
        orders.add(new Order(product, quantity));
    }

    public List<Order> getOrders() {
        return orders;
    }

}

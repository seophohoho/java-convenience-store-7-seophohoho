package store.service;

import java.util.ArrayList;
import java.util.List;
import store.Utils;
import store.model.Order;
import store.util.StringUtil;

public class OrderService {
    List<Order> orders = new ArrayList<>();

    public void takeOrder(String orderStrs){
        String[] separateOrder = StringUtil.separate(orderStrs,StringUtil.SEPARATOR_COMMA);

        for(String orderStr: separateOrder){
            String[] separate = StringUtil.separate(StringUtil.removeFirstAndLast(orderStr),StringUtil.SEPARATOR_HYPHEN);
            orders.add(new Order(separate[0],Integer.parseInt(separate[1]),0,0));
        }
    }

    public List<Order> getOrders() {
        return orders;
    }
}

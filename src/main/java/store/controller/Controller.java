package store.controller;

import java.io.IOException;
import java.util.List;
import store.model.Order;
import store.model.Receipt;
import store.model.Store;
import store.service.MembershipService;
import store.service.OrderService;
import store.service.PromotionService;
import store.view.Error;
import store.view.Input;
import store.view.Output;

public class Controller {
    private Store store;
    private OrderService orderService;
    private PromotionService promotionService;
    private MembershipService membershipService;

    public Controller() throws IOException {
        this.store = new Store();
        this.orderService = new OrderService(store);
        this.promotionService = new PromotionService(store);
        this.membershipService = new MembershipService();

        store.initPromotion();
        store.initProduct();
    }

    public void run() {
        boolean isAgainOrder = true;

        while (isAgainOrder) {
            try {
                order();
                checkOrders();
                processOrders();
                isAgainOrder = confirmAdditionalOrder();
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public void order() {
        Output.printWelcomeTitle();
        Output.printProducts(store.getProducts(), store.getPromotionProducts());

        String orderInput = Input.order();
        orderService.takeOrder(orderInput);
    }

    public void checkOrders() {
        List<Order> orders = orderService.getOrders();

        for (Order order : orders) {
            if (!orderService.isExistProducts(order.getProduct())) {
                Error.printError(Error.INVALID_PRODUCT_MSG);
            }

            if (orderService.isExceedQuantity(order.getProduct(), order.getQuantity())) {
                Error.printError(Error.INVALID_QUANTITY_MSG);
            }
        }
    }

    public void processOrders() {
        List<Order> orders = orderService.getOrders();
        int totalAmount = 0;
        int promotionDiscount = 0;

        for (Order order : orders) {
            int benefit = promotionService.calculatePromotionBenefit(order);
            order.setBenefit(benefit);
            orderService.processOrder(order, benefit);

            totalAmount += order.getAmount();
            promotionDiscount += promotionService.calculateDiscount(order, benefit);
        }

        int membershipDiscount = applyMembershipDiscount(totalAmount - promotionDiscount);
        int finalAmount = totalAmount - promotionDiscount - membershipDiscount;

        Receipt receipt = new Receipt(orders, totalAmount, promotionDiscount, membershipDiscount, finalAmount);
        Output.printReceipt(receipt);
    }

    private int applyMembershipDiscount(int amountAfterPromotion) {
        String input = Input.membershipChoice();
        if (input.equalsIgnoreCase("Y")) {
            return membershipService.calc(amountAfterPromotion);
        }
        return 0;
    }

    private boolean confirmAdditionalOrder() {
        String input = Input.confirmAdditionalOrder();
        return input.equalsIgnoreCase("Y");
    }
}

package store.model;

import java.util.List;

public class Receipt {
    private List<Order> orders;
    private int totalAmount;
    private int promotionDiscount;
    private int membershipDiscount;
    private int finalAmount;

    public Receipt(List<Order> orders, int totalAmount, int promotionDiscount, int membershipDiscount, int finalAmount) {
        this.orders = orders;
        this.totalAmount = totalAmount;
        this.promotionDiscount = promotionDiscount;
        this.membershipDiscount = membershipDiscount;
        this.finalAmount = finalAmount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getPromotionDiscount() {
        return promotionDiscount;
    }

    public int getMembershipDiscount() {
        return membershipDiscount;
    }

    public int getFinalAmount() {
        return finalAmount;
    }
}

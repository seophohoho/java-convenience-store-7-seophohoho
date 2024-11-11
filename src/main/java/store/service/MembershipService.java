package store.service;

public class MembershipService {
    private static final int DISCOUNT_RATE = 30;
    private static final int MAX_ACCOUNT = 8000;

    public int calc(int amount) {
        int discount = (amount * DISCOUNT_RATE) / 100;
        return Math.min(discount, MAX_ACCOUNT);
    }
}
package store.service;

import java.time.LocalDate;
import store.model.Order;
import store.model.Promotion;
import store.model.PromotionProduct;
import store.model.Store;
import store.util.DateUtil;

public class PromotionService {
    private Store store;

    public PromotionService(Store store) {
        this.store = store;
    }

    public int calculatePromotionBenefit(Order order) {
        PromotionProduct promotionProduct = store.getTargetProductPromotion(order.getProduct());
        if (promotionProduct == null) {
            return 0;
        }

        Promotion promotion = getPromotion(promotionProduct.getPromotion());
        if (isTodayPromotionPeriod(promotion.getStart(), promotion.getEnd())) {
            return (order.getQuantity() / promotion.getBuy() + promotion.getGet()) * promotion.getGet();
        }
        return 0;
    }

    public int calculateDiscount(Order order, int benefit) {
        PromotionProduct promotionProduct = store.getTargetProductPromotion(order.getProduct());
        if (promotionProduct == null || benefit == 0) {
            return 0;
        }
        return promotionProduct.getPrice() * benefit;
    }

    public Promotion getPromotion(String promotionName) {
        for (Promotion promotion : Promotion.values()) {
            if (promotion.getName().equals(promotionName)) {
                return promotion;
            }
        }
        return Promotion.EMPTY;
    }

    public boolean isTodayPromotionPeriod(String startDate, String endDate) {
        LocalDate today = LocalDate.now();
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return !today.isBefore(start) && !today.isAfter(end);
    }
}

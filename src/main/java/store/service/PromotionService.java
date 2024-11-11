package store.service;

import java.time.LocalDateTime;
import store.model.Order;
import store.model.Promotion;
import store.model.PromotionProduct;
import store.model.Store;
import store.util.DateUtil;

public class PromotionService {
    private Store store;

    public PromotionService(Store store){
        this.store = store;
    }

    public boolean isTodayPromotionPeriod(String startDate, String endDate){
        LocalDateTime today = DateUtil.getDateTimeNow();
        LocalDateTime start = DateUtil.strToLocalDateTime(startDate);
        LocalDateTime end = DateUtil.strToLocalDateTime(endDate);

        return today.equals(start) || today.equals(end) || (today.isAfter(start) && today.isBefore(end));
    }

    public Promotion getPromotion(String name){
        Promotion ret = Promotion.TWO_PLUS_ONE;
        for(Promotion promotion : Promotion.values()){
            if(promotion.getName().equals(name)){
                ret = promotion;
            }
        }
        return ret;
    }

    public int getBenefit(Order order, Promotion promotion){
        return order.getQuantity() % calcPromotionBuyGet(promotion);
    }

    public boolean compareOrderPromotion(Order order, PromotionProduct product){
        return order.getQuantity() > product.getQuantity();
    }

    private int calcPromotionBuyGet(Promotion promotion){
        return promotion.getBuy() + promotion.getGet();
    }

}

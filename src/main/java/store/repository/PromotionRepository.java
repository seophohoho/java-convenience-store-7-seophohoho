package store.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import store.dto.Promotion;

public class PromotionRepository {
    private Map<String, Promotion> promotions = new HashMap<>();

    public Promotion createPromotion(List<String> lines) {
        String name = lines.get(0);
        int buy = Integer.parseInt(lines.get(1));
        int get = Integer.parseInt(lines.get(2));
        String startDate = lines.get(3);
        String endDate = lines.get(4);

        Promotion value = new Promotion(name, buy, get, startDate, endDate);

        return value;
    }

    public void setPromotion(String key, Promotion value) {
        promotions.put(key, value);
    }

    public Promotion getPromotion(String key) {
        return promotions.get(key);
    }
}

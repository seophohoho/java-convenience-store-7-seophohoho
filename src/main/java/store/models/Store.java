package store.models;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Store {
    Map<String, Product> products = new LinkedHashMap<>();
    Map<String, Promotion> promotions = new HashMap<>();

    public void setProducts(List<String> lines){
    }

    public Promotion createPromotion(List<String> lines){
        String name = lines.get(0);
        int buy = Integer.parseInt(lines.get(1));
        int get = Integer.parseInt(lines.get(2));
        String startDate = lines.get(3);
        String endDate = lines.get(4);

        Promotion value = new Promotion(name,buy,get,startDate,endDate);

        return value;
    }

    public void setPromotion(String key, Promotion value){
        promotions.put(key,value);
    }
}

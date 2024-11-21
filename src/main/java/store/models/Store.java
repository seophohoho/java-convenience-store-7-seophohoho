package store.models;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Store {
    private static final String DEFAULT = "default";
    private static final String PROMOTION = "promotion";

    Map<String, ProductDefault> defaultProducts = new LinkedHashMap<>();
    Map<String, ProductPromotion> promotionProducts = new LinkedHashMap<>();
    Map<String, Promotion> promotions = new HashMap<>();

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

    public void setDefaultOrPromotionProducts(List<String> lines){
        String name = lines.get(0);
        int price = Integer.parseInt(lines.get(1));
        int stock = Integer.parseInt(lines.get(2));
        String type = lines.get(3);

        if(type.equals("null")){
            defaultProducts.put(name,createDefaultProduct(name,price,stock));
        }

        if(!type.equals("null")){
            promotionProducts.put(name,createPromotionProduct(name,price,stock,type));
            defaultProducts.put(name,createDefaultProduct(name,price,0));
        }


    }

    public ProductDefault createDefaultProduct(String name, int price, int stock){
        return new ProductDefault(name,price,stock);
    }

    public ProductPromotion createPromotionProduct(String name, int price, int stock, String type){
        return new ProductPromotion(name,price,stock,type);
    }


}

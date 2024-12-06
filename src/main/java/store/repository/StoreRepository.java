package store.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import store.dto.ProductDefault;
import store.dto.ProductPromotion;

public class StoreRepository {
    private Map<String, ProductDefault> defaultProducts = new LinkedHashMap<>();
    private Map<String, ProductPromotion> promotionProducts = new LinkedHashMap<>();

    public ProductDefault getDefaultProduct(String target) {
        if (!defaultProducts.containsKey(target)) {
            return null;
        }
        return defaultProducts.get(target);
    }

    public ProductPromotion getPromotionProduct(String target) {
        if (!promotionProducts.containsKey(target)) {
            return null;
        }
        return promotionProducts.get(target);
    }

    public Map<String, ProductDefault> getDefaultProducts() {
        return defaultProducts;
    }

    public Map<String, ProductPromotion> getPromotionProducts() {
        return promotionProducts;
    }

    public void addDefaultOrPromotionProducts(List<String> lines) {
        String name = lines.get(0);
        int price = Integer.parseInt(lines.get(1));
        int stock = Integer.parseInt(lines.get(2));
        String type = lines.get(3);

        if (type.equals("null")) {
            defaultProducts.put(name, createDefaultProduct(name, price, stock));
        }

        if (!type.equals("null")) {
            promotionProducts.put(name, createPromotionProduct(name, price, stock, type));
            defaultProducts.put(name, createDefaultProduct(name, price, 0));
        }
    }

    private ProductDefault createDefaultProduct(String name, int price, int stock) {
        return new ProductDefault(name, price, stock);
    }

    private ProductPromotion createPromotionProduct(String name, int price, int stock, String type) {
        return new ProductPromotion(name, price, stock, type);
    }
}

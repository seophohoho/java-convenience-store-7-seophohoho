package store.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import store.util.FileUtil;
import store.util.StringUtil;

public class Store {
    private static final String FILENAME_PRODUCT = "products.md";
    private static final String FILENAME_PROMOTION = "promotions.md";
    private static final String PROMOTION_NULL = "null";

    Map<String,Product> products = new LinkedHashMap<>();
    Map<String,PromotionProduct> promotionProducts = new LinkedHashMap<>();

    public void initProduct() throws IOException {
        BufferedReader br = FileUtil.read(FILENAME_PRODUCT);
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            setProductsDefaultOrPromotion(StringUtil.separate(line,StringUtil.SEPARATOR_COMMA));
        }

        br.close();
    }

    public void initPromotion() throws IOException{
        Promotion[] promotions = Promotion.values();
        BufferedReader br = FileUtil.read(FILENAME_PROMOTION);
        br.readLine();

        String line;
        int idx=0;
        while ((line = br.readLine()) != null) {
            String[] separate = StringUtil.separate(line,StringUtil.SEPARATOR_COMMA);
            promotions[idx+1].setName(separate[0]);
            promotions[idx+1].setBuy(Integer.parseInt(separate[1]));
            promotions[idx+1].setGet(Integer.parseInt(separate[2]));
            promotions[idx+1].setStart(separate[3]);
            promotions[idx+1].setEnd(separate[4]);
            idx++;
        }

        br.close();
    }

    public Map<String,Product> getProducts(){
        return products;
    }

    public Map<String,PromotionProduct> getPromotionProducts(){
        return promotionProducts;
    }

    public Product getTargetProductDefault(String product){
        return products.get(product);
    }

    public PromotionProduct getTargetProductPromotion(String product){
        return promotionProducts.get(product);
    }

    public void setProductsDefaultOrPromotion(String[] rows){
        if(rows[3].equals(PROMOTION_NULL)){
            products.put(rows[0],createProduct(rows[0],Integer.parseInt(rows[1]),Integer.parseInt(rows[2])));
        }

        if(!rows[3].equals(PROMOTION_NULL)){
            promotionProducts.put(rows[0],createPromotionProduct(rows[0],Integer.parseInt(rows[1]),Integer.parseInt(rows[2]),rows[3]));
            products.put(rows[0],createProduct(rows[0],Integer.parseInt(rows[1]),0));
        }
    }

    public Product createProduct(String name, int price, int quantity){
        return new Product(name,price,quantity);
    }

    public PromotionProduct createPromotionProduct(String name, int price, int quantity, String promotion){
        return new PromotionProduct(name,price,quantity,promotion);
    }

}

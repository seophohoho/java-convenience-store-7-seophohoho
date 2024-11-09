package store.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import store.Utils;

public class Store {
    Map<String,Product> productsDefault = new HashMap<>();
    Map<String,Product> productsPromotion = new HashMap<>();

    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_HYPHEN = "-";
    private static final String FILENAME_PRODUCT = "products.md";
    private static final String FILENAME_PROMOTION = "promotions.md";
    private static final String PROMOTION_NULL = "null";

    public Map<String,Product> getProductDefault(){
        return productsDefault;
    }
    public Map<String,Product> getProductPromotion(){
        return productsPromotion;
    }

    public void initProduct() throws IOException {
        BufferedReader br = Utils.readFile(FILENAME_PRODUCT);
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            setProductsDefaultOrPromotion(Utils.separateStr(line,SEPARATOR_COMMA));
        }

        br.close();
    }

    public void setProductsDefaultOrPromotion(String[] rows){
        Product newProduct = new Product(rows[0],Integer.parseInt(rows[1]),Integer.parseInt(rows[2]),rows[3]);

        if(!rows[3].equals(PROMOTION_NULL)){
            productsPromotion.put(rows[0],newProduct);
            productsDefault.put(rows[0],new Product(rows[0],Integer.parseInt(rows[1]),0,PROMOTION_NULL));
            return;
        }
        productsDefault.put(rows[0],newProduct);
    }

    public void initPromotion() throws IOException{
        Promotion[] promotions = Promotion.values();
        BufferedReader br = Utils.readFile(FILENAME_PROMOTION);
        br.readLine();

        String line;
        int idx=0;
        while ((line = br.readLine()) != null) {
            String[] separate = Utils.separateStr(line,SEPARATOR_COMMA);
            promotions[idx].setName(separate[0]);
            promotions[idx].setBuy(Integer.parseInt(separate[1]));
            promotions[idx].setGet(Integer.parseInt(separate[2]));
            promotions[idx].setStart(separate[3]);
            promotions[idx].setEnd(separate[4]);
            idx++;
        }

        br.close();
    }

}

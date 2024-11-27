package store.controllers;

import java.io.IOException;
import java.util.List;
import javax.naming.ldap.Control;
import store.models.Promotion;
import store.models.Store;
import store.utils.FileUtil;
import store.utils.StringUtil;
import store.views.Input;
import store.views.Output;

public class Controller {
    private static final String FILENAME_PROMOTION = "promotions.md";
    private static final String FILENAME_PRODUCT = "products.md";

    private static final String DELIMITER_COMMA = ",";

    private Store store;

    public Controller(Store store){
        this.store = store;
    }

    public void run() throws IOException {
        init();
        welcome();
        order();
    }

    public void init() throws IOException {
        initPromotions();
        initProducts();
    }

    public void initPromotions() throws IOException {
        List<String> lines = FileUtil.readLine(FILENAME_PROMOTION);

        for(String line : lines){
            Promotion promotion = this.store.createPromotion(StringUtil.separate(line,DELIMITER_COMMA));
            this.store.setPromotion(promotion.getName(),promotion);
        }
    }

    public void initProducts() throws IOException {
        List<String> lines = FileUtil.readLine(FILENAME_PRODUCT);

        for(String line : lines){
            this.store.setDefaultOrPromotionProducts(StringUtil.separate(line,DELIMITER_COMMA));
        }
    }

    public void welcome(){
        Output.printWelcome();
        Output.printProducts(store.getDefaultProducts(),store.getPromotionProducts());
    }

    public void order(){
        Input.readOrder();
    }
}

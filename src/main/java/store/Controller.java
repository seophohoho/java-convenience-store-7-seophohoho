package store.controllers;

import java.io.IOException;
import java.util.List;
import store.dto.Promotion;
import store.repository.StoreRepository;
import store.utils.FileUtil;
import store.utils.StringUtil;

public class Controller {
    private static final String FILENAME_PROMOTION = "promotions.md";
    private static final String FILENAME_PRODUCT = "products.md";
    private final StoreRepository storeRepository;

    public Controller(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void run() throws IOException {
        init();
    }

    public void init() throws IOException {
        initPromotions();
        initProducts();
    }

    public void initPromotions() throws IOException {
        List<String> lines = FileUtil.readLine(FILENAME_PROMOTION);

        for (String line : lines) {
            Promotion promotion = this.storeRepository.createPromotion(
                    StringUtil.separate(line, StringUtil.DELIMITER_COMMA));
            this.store.setPromotion(promotion.getName(), promotion);
        }
    }

    public void initProducts() throws IOException {
        List<String> lines = FileUtil.readLine(FILENAME_PRODUCT);

        for (String line : lines) {
            this.store.setDefaultOrPromotionProducts(StringUtil.separate(line, StringUtil.DELIMITER_COMMA));
        }
    }
}

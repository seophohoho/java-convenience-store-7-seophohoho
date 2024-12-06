package store;

import java.io.IOException;
import java.util.List;
import store.dto.Promotion;
import store.repository.PromotionRepository;
import store.repository.StoreRepository;
import store.utils.FileUtil;
import store.utils.StringUtil;
import store.views.Input;
import store.views.Output;

public class Controller {
    private static final String FILENAME_PROMOTION = "promotions.md";
    private static final String FILENAME_PRODUCT = "products.md";
    private final StoreRepository storeRepository;
    private final PromotionRepository promotionRepository;

    public Controller(StoreRepository storeRepository, PromotionRepository promotionRepository) {
        this.storeRepository = storeRepository;
        this.promotionRepository = promotionRepository;
    }

    public void run() throws IOException {
        init();
        welcome();
        order();
    }

    private void welcome() {
        Output.printWelcome();
        Output.printProducts(this.storeRepository.getDefaultProducts(), this.storeRepository.getPromotionProducts());
    }

    private void order() {
        String input = Input.readOrder();
        Validator.order(input);
    }

    private void init() throws IOException {
        initPromotions();
        initProducts();
    }

    private void initPromotions() throws IOException {
        List<String> lines = FileUtil.readLine(FILENAME_PROMOTION);

        for (String line : lines) {
            Promotion promotion = this.promotionRepository.createPromotion(
                    StringUtil.separate(line, StringUtil.DELIMITER_COMMA));
            this.promotionRepository.setPromotion(promotion.getName(), promotion);
        }
    }

    private void initProducts() throws IOException {
        List<String> lines = FileUtil.readLine(FILENAME_PRODUCT);

        for (String line : lines) {
            this.storeRepository.addDefaultOrPromotionProducts(StringUtil.separate(line, StringUtil.DELIMITER_COMMA));
        }
    }
}

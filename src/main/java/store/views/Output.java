package store.views;

import java.util.Map;
import store.dto.ProductDefault;
import store.dto.ProductPromotion;

public class Output {
    private static final String PRINT_ERROR = "[ERROR] ";
    private static final String PRINT_WELCOME_1 = "안녕하세요. W편의점입니다.%n";
    private static final String PRINT_WELCOME_2 = "현재 보유하고 있는 상품입니다.%n%n";
    private static final String PRINT_PRODUCT_PROMOTION_EXIST = "- %s %,3d원 %s개 %s%n";
    private static final String PRINT_PRODUCT_PROMOTION_NOT_EXIST = "- %s %,3d원 재고 없음 %s%n";
    private static final String PRINT_PRODUCT_DEFAULT_EXIST = "- %s %,3d원 %s개%n";
    private static final String PRINT_PRODUCT_DEFAULT_NOT_EXIST = "- %s %,3d원 재고 없음%n";

    public static void printError(String message) {
        System.out.println(PRINT_ERROR + message);
    }

    public static void printWelcome() {
        System.out.printf(PRINT_WELCOME_1);
        System.out.printf(PRINT_WELCOME_2);
    }

    public static void printProducts(Map<String, ProductDefault> defaultProducts,
                                     Map<String, ProductPromotion> promotionProducts) {
        for (ProductDefault productDefault : defaultProducts.values()) {
            String productName = productDefault.getName();
            ProductPromotion promotionProduct = promotionProducts.get(productName);

            if (promotionProduct != null) {
                System.out.printf(PRINT_PRODUCT_PROMOTION_EXIST, productName, promotionProduct.getPrice(),
                        promotionProduct.getStock(), promotionProduct.getType());
            }

            if (promotionProduct != null && promotionProduct.getStock() == 0) {
                System.out.printf(PRINT_PRODUCT_PROMOTION_NOT_EXIST, productName, promotionProduct.getPrice(),
                        promotionProduct.getType());
            }

            if (productDefault.getStock() > 0) {
                System.out.printf(PRINT_PRODUCT_DEFAULT_EXIST, productName, productDefault.getPrice(),
                        productDefault.getStock());
            }

            if (productDefault.getStock() == 0) {
                System.out.printf(PRINT_PRODUCT_DEFAULT_NOT_EXIST, productName, productDefault.getPrice());
            }
        }
    }

}

package store.view;

import java.util.Map;
import store.model.Product;
import store.model.PromotionProduct;
import store.util.StringUtil;

public class Output {
    private static final String WELCOME_TITLE = "안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.\n\n";
    private static final String PRODUCTS_TITLE = "현재 보유하고 있는 상품입니다.\n";

    public static void printWelcomeTitle(){
        System.out.print(WELCOME_TITLE);
    }

    public static void printProducts(Map<String, Product> products, Map<String, PromotionProduct> promotionProducts){
        for(Product product : products.values()){
            String targetProduct = product.getName();
            PromotionProduct targetPromotionProduct = promotionProducts.get(targetProduct);

            if(targetPromotionProduct != null){
                System.out.printf("- %s %s원 %s개 %s%n", product.getName(), StringUtil.priceToStr(product.getPrice()), targetPromotionProduct.getQuantity(), targetPromotionProduct.getPromotion());
            }

            if(product.getQuantity() == 0){
                System.out.printf("- %s %s원 재고 없음%n", product.getName(),StringUtil.priceToStr(product.getPrice()));
            }

            if(product.getQuantity() > 0){
                System.out.printf("- %s %s원 %s개%n", product.getName(), StringUtil.priceToStr(product.getPrice()), product.getQuantity());
            }
        }
    }
}

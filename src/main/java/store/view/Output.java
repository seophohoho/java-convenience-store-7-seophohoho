package store.view;

import java.util.Map;
import store.model.Order;
import store.model.Product;
import store.model.PromotionProduct;
import store.model.Receipt;
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

    public static void printReceipt(Receipt receipt) {
        System.out.println("==============W 편의점================");
        System.out.println("상품명\t\t\t수량\t\t\t금액");
        for (Order order : receipt.getOrders()) {
            System.out.printf("%s\t\t\t%4d\t\t\t%s%n", order.getProduct(), order.getQuantity(), StringUtil.priceToStr(order.getAmount()));
        }

        System.out.println("=============증정=============");
        for (Order order : receipt.getOrders()) {
            if (order.getBenefit() > 0) {
                System.out.printf("%s\t\t\t%4d\t\t\t%n", order.getProduct(), order.getBenefit());
            }
        }

        System.out.println("====================================");
        System.out.printf("총구매액\t\t\t%4d\t\t\t%s%n", receipt.getOrders().size(),StringUtil.priceToStr(receipt.getTotalAmount()));
        System.out.printf("행사할인\t\t\t\t\t\t-%s%n", StringUtil.priceToStr(receipt.getPromotionDiscount()));
        System.out.printf("멤버십할인\t\t\t\t\t\t-%s%n", StringUtil.priceToStr(receipt.getMembershipDiscount()));
        System.out.printf("내실돈\t\t\t\t\t\t%s%n", StringUtil.priceToStr(receipt.getFinalAmount()));
    }
}

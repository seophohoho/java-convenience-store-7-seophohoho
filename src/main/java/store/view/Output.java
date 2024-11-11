package store.view;

import java.util.Map;
import store.model.Order;
import store.model.Product;
import store.model.PromotionProduct;
import store.model.Receipt;
import store.util.StringUtil;

public class Output {
    private static final String WELCOME_TITLE = "안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.\n\n";
    private static final String PRINT_PRODUCTS_1 = "- %s %s원 %s개 %s%n";
    private static final String PRINT_PRODUCTS_2 = "- %s %s원 재고 없음%n";
    private static final String PRINT_PRODUCTS_3 = "- %s %s원 %s개%n";
    private static final String PRINT_RECEIPT_TITLE = "==============W 편의점================";
    private static final String PRINT_RECEIPT_1 = "상품명\t\t수량\t\t금액";
    private static final String PRINT_RECEIPT_2 = "%s\t\t%-1d\t\t%-,1d%n";
    private static final String PRINT_RECEIPT_3 = "=============증  정=============";
    private static final String PRINT_RECEIPT_4 = "%-6s\t\t%-,1d%n";
    private static final String PRINT_RECEIPT_5 = "====================================";
    private static final String PRINT_RECEIPT_6 = "총구매액\t\t%-1d\t\t%,3d%n";
    private static final String PRINT_RECEIPT_7 = "행사할인\t\t\t\t-%-,1d%n";
    private static final String PRINT_RECEIPT_8 = "멤버십할인\t\t\t\t-%-,1d%n";
    private static final String PRINT_RECEIPT_9 = "내실돈\t\t\t\t%-,1d%n";

    public static void printWelcomeTitle(){
        System.out.print(WELCOME_TITLE);
    }

    public static void printProducts(Map<String, Product> products, Map<String, PromotionProduct> promotionProducts){
        for(Product product : products.values()){
            String targetProduct = product.getName();
            PromotionProduct targetPromotionProduct = promotionProducts.get(targetProduct);

            if(targetPromotionProduct != null){
                System.out.printf(PRINT_PRODUCTS_1, product.getName(), StringUtil.priceToStr(product.getPrice()), targetPromotionProduct.getQuantity(), targetPromotionProduct.getPromotion());
            }

            if(product.getQuantity() == 0){
                System.out.printf(PRINT_PRODUCTS_2, product.getName(),StringUtil.priceToStr(product.getPrice()));
            }

            if(product.getQuantity() > 0){
                System.out.printf(PRINT_PRODUCTS_3, product.getName(), StringUtil.priceToStr(product.getPrice()), product.getQuantity());
            }
        }
    }

    public static void printReceipt(Receipt receipt) {
        System.out.println(PRINT_RECEIPT_TITLE);
        System.out.println(PRINT_RECEIPT_1);

        for (Order order : receipt.getOrders()) {
            System.out.printf(PRINT_RECEIPT_2, order.getProduct(), order.getQuantity(), order.getAmount());
        }

        System.out.println(PRINT_RECEIPT_3);
        for (Order order : receipt.getOrders()) {
            if (order.getBenefit() > 0) {
                System.out.printf(PRINT_RECEIPT_4, order.getProduct(), order.getBenefit());
            }
        }

        System.out.println(PRINT_RECEIPT_5);
        System.out.printf(PRINT_RECEIPT_6, receipt.getOrders().size(), receipt.getTotalAmount());
        System.out.printf(PRINT_RECEIPT_7, receipt.getPromotionDiscount());
        System.out.printf(PRINT_RECEIPT_8, receipt.getMembershipDiscount());
        System.out.printf(PRINT_RECEIPT_9, receipt.getFinalAmount());
    }
}

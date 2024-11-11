package store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import store.model.Order;
import store.model.Product;
import store.model.PromotionProduct;
import store.model.Store;
import store.util.StringUtil;
import store.view.Error;

public class OrderService {
    private static final String ORDER_PATTERN = "\\[([가-힣]*|[[a-zA-Z]]*+)-([1-9][0-9]*+)](,\\[([가-힣]*|[[a-zA-Z]]*+)-([1-9][0-9]*+)])*";
    private Store store;
    List<Order> orders = new ArrayList<>();

    public OrderService(Store store){
        this.store = store;
    }

    public void takeOrder(String orderStrs){
        String[] separateOrder = StringUtil.separate(orderStrs,StringUtil.SEPARATOR_COMMA);

        validate(orderStrs);

        for(String orderStr: separateOrder){
            String[] separate = StringUtil.separate(StringUtil.removeFirstAndLast(orderStr),StringUtil.SEPARATOR_HYPHEN);
            orders.add(new Order(separate[0],Integer.parseInt(separate[1])));
        }
    }

    public void validate(String input){
        Pattern patternOrder = Pattern.compile(ORDER_PATTERN);
        Matcher matcherOrder = patternOrder.matcher(input);

        if(!matcherOrder.matches()){
            Error.printError(Error.INVALID_INPUT_MSG);

        }
    }

    public boolean isExistProducts(String product){
        return store.getProducts().containsKey(product) || store.getPromotionProducts().containsKey(product);
    }

    public boolean isExceedQuantity(String product,int quantity){
        return getProductQuantity(product) < quantity;
    }

    private int getProductQuantity(String product){
        int productDefaultQuantity = 0;
        int productPromotionQuantity = 0;
        Product productDefault = store.getTargetProductDefault(product);
        PromotionProduct productPromotion = store.getTargetProductPromotion(product);

        if(productDefault != null){
            productDefaultQuantity = productDefault.getQuantity();
        }

        if(productPromotion != null){
            productPromotionQuantity = productPromotion.getQuantity();
        }

        return productDefaultQuantity + productPromotionQuantity;
    }

    public void process(Order order,PromotionProduct promotionProduct, int benefit){
        for(int i=0;i<order.getQuantity()-benefit;i++){
            if(promotionProduct != null || promotionProduct.getQuantity() == 0){
                PromotionProduct target = store.getTargetProductPromotion(order.getProduct());
                target.reduceQuantity(1);
                order.setAmount(order.getAmount()+target.getPrice());
                continue;
            }
            Product target = store.getTargetProductDefault(order.getProduct());
            target.reduceQuantity(1);
            order.setAmount(order.getAmount()+target.getPrice());
        }
    }

    public void processOrder(Order order, int benefit) {
        Product product = store.getTargetProductDefault(order.getProduct());
        int quantityToProcess = order.getQuantity() - (benefit / product.getPrice());

        product.reduceQuantity(quantityToProcess);
        order.setAmount(product.getPrice() * quantityToProcess);
        order.setBenefit(benefit);
    }

    public int calculateTotalAmount() {
        int totalAmount = 0;
        for (Order order : orders) {
            totalAmount += order.getAmount();
        }
        return totalAmount;
    }

    public List<Order> getOrders() {
        return orders;
    }
}

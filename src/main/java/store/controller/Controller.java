package store.controller;

import java.io.IOException;
import java.util.List;
import store.model.Order;
import store.model.Promotion;
import store.model.PromotionProduct;
import store.model.Store;
import store.service.OrderService;
import store.service.PromotionService;
import store.view.Error;
import store.view.Input;
import store.view.Output;

public class Controller {
    private Store store;
    private OrderService orderService;
    private PromotionService promotionService;

    public Controller() throws IOException{
        this.store = new Store();
        this.orderService = new OrderService(store);
        this.promotionService = new PromotionService(store);

        store.initPromotion();
        store.initProduct();
    }

    public void run() {
        boolean isAgainOrder = true;

        while(isAgainOrder){
            try{
                order();
                checkOrders();

            }catch(IllegalArgumentException e){}
        }

    }

    public void order(){
        Output.printWelcomeTitle();
        Output.printProducts(store.getProducts(),store.getPromotionProducts());

        String orderInput = Input.order();
        orderService.takeOrder(orderInput);
    }

    public void checkOrders(){
        List<Order> orders = orderService.getOrders();

        for(Order order: orders){
            if(!orderService.isExistProducts(order.getProduct())){
                Error.printError(Error.INVALID_PRODUCT_MSG);
            }

            if(orderService.isExceedQuantity(order.getProduct(),order.getQuantity())){
                Error.printError(Error.INVALID_QUANTITY_MSG);
            }
        }
    }

    public void processOrders(){
        List<Order> orders = orderService.getOrders();
        for(Order order: orders){
            int result1 = checkPromotion_1(order);
            if(result1 > 0){
                order.setQuantity(order.getQuantity()+result1);
            }

        }
    }

    public int checkPromotion_1(Order order){
        Promotion promotion = Promotion.EMPTY;
        PromotionProduct targetProductPromotion = store.getTargetProductPromotion(order.getProduct());
        if(targetProductPromotion != null){
            promotion = promotionService.getPromotion(targetProductPromotion.getName());
        }

        if(!promotion.equals(Promotion.EMPTY) && promotionService.isTodayPromotionPeriod(promotion.getStart(),promotion.getEnd())){
            return hasPromotionBenefit(order,promotion);
        }
        return 0;
    }

    public int hasPromotionBenefit(Order order, Promotion promotion){
        int remainder = promotionService.getBenefit(order,promotion);

        if(remainder != 0){
            String input = Input.promotionBenefitChoice(order.getProduct(),remainder);
            if(input.equals("Y")){
                return remainder;
            }
        }
        return 0;
    }

}

package store.controller;

import java.io.IOException;
import java.util.List;
import store.model.Order;
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

            }catch(IllegalArgumentException e){}
        }

    }

    public void order(){
        Output.printWelcomeTitle();
        Output.printProducts(store.getProducts(),store.getPromotionProducts());

        String orderInput = Input.order();
        orderService.takeOrder(orderInput);
    }
}

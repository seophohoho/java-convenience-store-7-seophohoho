package store.model;

public class PromotionProduct extends Product{
    private String promotion;

    public PromotionProduct(String name, int price, int quantity, String promotion) {
        super(name, price, quantity);
        this.promotion = promotion;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }
}

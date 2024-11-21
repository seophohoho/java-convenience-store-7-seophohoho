package store.models;

public class ProductPromotion extends Product{
    private String type;

    public ProductPromotion(String name, int price, int stock, String type){
        super(name,price,stock);
        this.type = type;
    }
}
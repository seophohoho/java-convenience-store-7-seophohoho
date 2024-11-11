package store.model;

public class Product {
    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void reduceQuantity(int quantity){
        int originQuantity = getQuantity();
        int resultQuantity = originQuantity - quantity;

        setQuantity(resultQuantity);

        if(resultQuantity < 0){
            setQuantity(0);
        }
    }
}

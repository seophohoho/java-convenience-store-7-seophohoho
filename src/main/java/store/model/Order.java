package store.model;

public class Order {
    private String product;
    private int quantity;
    private int amount;
    private int benefit;

    public Order(String product, int quantity, int amount, int benefit){
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
        this.benefit = benefit;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBenefit() {
        return benefit;
    }

    public void setBenefit(int benefit) {
        this.benefit = benefit;
    }
}

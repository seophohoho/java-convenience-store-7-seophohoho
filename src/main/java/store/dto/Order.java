package store.dto;

public class Order {
    private String product;
    private int quantity;
    private OrderStatus status;
    private ErrorGroup detail;

    public Order(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.status = OrderStatus.READY;
        this.detail = ErrorGroup.EMPTY;
    }
}

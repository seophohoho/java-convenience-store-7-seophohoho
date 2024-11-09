package store.view;

public class Error {
    public static final String BASIC_MSG = "[ERROR] ";
    public static final String INVALID_INPUT_MSG = "올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.";
    public static final String INVALID_PRODUCT_MSG = "존재하지 않는 상품입니다. 다시 입력해 주세요.";
    public static final String INVALID_QUANTITY_MSG = "재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요.";
    public static final String INVALID_ETC_MSG = "잘못된 입력입니다. 다시 입력해 주세요.";

    public static void reject(String msg) {
        throw new IllegalArgumentException(BASIC_MSG + msg);
    }
}

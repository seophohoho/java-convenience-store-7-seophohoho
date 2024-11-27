package store.models;

import java.util.Arrays;

public enum ErrorGroup {
    WRONG_INPUT(0, "잘못된 입력입니다. 다시 입력해 주세요."),
    INVALID_FORM(1, "올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요."),
    NOTHING_PRODUCT(2, "존재하지 않는 상품입니다. 다시 입력해 주세요."),
    OUT_OF_STOCK(3, "재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요."),
    EMPTY(-1, "NULL");

    private int code;
    private String message;

    ErrorGroup(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorGroup findByErrorGroup(int code) {
        return Arrays.stream(ErrorGroup.values())
                .filter(group -> group.code == code)
                .findAny()
                .orElse(EMPTY);
    }
}

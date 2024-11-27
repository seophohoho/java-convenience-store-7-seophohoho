package store.models;

public enum Error {
    WRONG_INPUT(0,"올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요."),
    INVALID_FORM(1,),
    NOTHING_PRODUCT(),
    OUT_OF_STOCK(),

    private int code;
    private String message;

    Error()

    public
}

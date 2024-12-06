package store;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import store.dto.ErrorGroup;

public class Validator {
    private static final String ORDER_PATTERN = "\\[([가-힣a-zA-Z0-9]+)-([1-9]+[0-9]*)\\](,\\[([가-힣a-zA-Z0-9]+)-([1-9]+[0-9]*)\\])*";

    public static ErrorGroup orderInputForm(String input) {
        ErrorGroup ret = ErrorGroup.EMPTY;
        Pattern patternPay = Pattern.compile(ORDER_PATTERN);
        Matcher matcherPay = patternPay.matcher(input);

        if (!matcherPay.matches()) {
            return ErrorGroup.findByErrorGroup(1);
        }

        return ret;
    }
}

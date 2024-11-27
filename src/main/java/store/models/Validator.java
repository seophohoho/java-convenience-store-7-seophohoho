package store.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String ORDER_PATTERN = "\\[([가-힣a-zA-Z0-9\\p{Punct}]+)-([1-9]+[0-9]*)\\](,\\[([가-힣a-zA-Z0-9\\p{Punct}]+)-([1-9]+[0-9]*)\\])*";

    public ErrorGroup order(String input) {
        Pattern patternPay = Pattern.compile(ORDER_PATTERN);
        Matcher matcherPay = patternPay.matcher(input);

        if (!matcherPay.matches()) {
            return ErrorGroup.findByErrorGroup(1);
        }

        return ErrorGroup.EMPTY;
    }
}

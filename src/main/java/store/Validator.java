package store.models;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import store.dto.ProductDefault;
import store.utils.StringUtil;

public class Validator {
    private static final String ORDER_PATTERN = "\\[([가-힣a-zA-Z0-9\\p{Punct}]+)-([1-9]+[0-9]*)\\](,\\[([가-힣a-zA-Z0-9\\p{Punct}]+)-([1-9]+[0-9]*)\\])*";

    public ErrorGroup order(String input) {
        ErrorGroup ret = ErrorGroup.EMPTY;
        Pattern patternPay = Pattern.compile(ORDER_PATTERN);
        Matcher matcherPay = patternPay.matcher(input);

        if (!matcherPay.matches()) {
            return ErrorGroup.findByErrorGroup(1);
        }

        if (!hasProduct(StringUtil.separate(input, StringUtil.DELIMITER_COMMA))) {
            return ErrorGroup.findByErrorGroup(2);
        }

        return ret;
    }

    public boolean hasProduct(List<String> orderForms) {
        Map<String, ProductDefault> defaultProducts = Store.getInstance().getDefaultProducts();

        for (String orderForm : orderForms) {
            String trimOrder = StringUtil.trimFirstAndLast(orderForm);
            String targetProduct = StringUtil.separate(trimOrder, StringUtil.DELIMITER_HYPEN).get(0);

            if (!defaultProducts.containsKey(targetProduct)) {
                return false;
            }
        }

        return true;
    }
}

package store.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import store.view.Error;

public class Validator {
    private static final String ORDER_PATTERN = "\\[([가-힣]*|[[a-zA-Z]]*+)-([1-9][0-9]*+)](,\\[([가-힣]*|[[a-zA-Z]]*+)-([1-9][0-9]*+)])*";

    public boolean orderValidate(String input){
        Pattern patternOrder = Pattern.compile(ORDER_PATTERN);
        Matcher matcherOrder = patternOrder.matcher(input);

        if(!matcherOrder.matches()){
            Error.reject(Error.INVALID_INPUT_MSG);
        }
        return true;
    }
}

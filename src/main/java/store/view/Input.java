package store.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String ORDER_INPUT_TITLE = "\n구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])\n";

    public static String order(){
        System.out.print(ORDER_INPUT_TITLE);
        return Console.readLine();
    }
}

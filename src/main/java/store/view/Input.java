package store.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String ORDER_INPUT_TITLE = "\n구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])\n";

    public static String order(){
        System.out.print(ORDER_INPUT_TITLE);
        return Console.readLine();
    }

    public static String promotionBenefitChoice(String product, int remainder){
        System.out.printf("현재 %s은(는) %d개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)%n", product, remainder);
        return Console.readLine();
    }

    public static String promotionNotApplyChoice(String product, int value){
        System.out.printf("현재 %s %d개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)%n", product, value);
        return Console.readLine();
    }
}

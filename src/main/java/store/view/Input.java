package store.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String ORDER_INPUT_TITLE = "\n구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])\n";
    private static final String PROMOTION_BENEFIT_CHOICE = "\n현재 %s은(는) %d개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)%n";
    private static final String PROMOTION_NOT_APPLY_CHOICE = "\n현재 %s %d개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)%n";
    private static final String MEMBERSHIP_CHOICE = "\n멤버십 할인을 받으시겠습니까? (Y/N)";
    private static final String AGAIN_ORDER = "\n감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N):";

    public static String order(){
        System.out.print(ORDER_INPUT_TITLE);
        return Console.readLine();
    }

    public static String promotionBenefitChoice(String product, int remainder){
        System.out.printf(PROMOTION_BENEFIT_CHOICE, product, remainder);
        return Console.readLine();
    }

    public static String promotionNotApplyChoice(String product, int value){
        System.out.printf(PROMOTION_NOT_APPLY_CHOICE, product, value);
        return Console.readLine();
    }

    public static String membershipChoice() {
        System.out.println(MEMBERSHIP_CHOICE);
        return Console.readLine();
    }

    public static String againOrder() {
        System.out.println(AGAIN_ORDER);
        return Console.readLine();
    }
}

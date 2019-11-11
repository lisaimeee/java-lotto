package step2.view;

import java.util.Scanner;

public class InputView {
    private static final String AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static final String AMOUNT_EXCEPTION = "금액은 0보다 작을 수 없습니다.";

    private static Scanner scanner = new Scanner(System.in);

    public static String inputWinningNumbers() {
        scanner.nextLine();
        System.out.println(WINNING_NUMBER);
        return scanner.nextLine();
    }

    public static int buyTicket() {
        System.out.println(AMOUNT);
        int amount = scanner.nextInt();
        if (amount < 0) {
            throw new IllegalArgumentException(AMOUNT_EXCEPTION);
        }
        return amount;
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return scanner.nextInt();
    }
}

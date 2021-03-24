package calculator.view;

import calculator.domain.StringAdditionExpression;

import java.util.Scanner;

public class InputView {
    private static final String SUFFIX_PATTERN = "\\\\n";

    private InputView() {

    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String formatted = scanner.nextLine()
                    .replaceAll(SUFFIX_PATTERN, StringAdditionExpression.CUSTOM_SUFFIX);
            return formatted;
        }
        throw new IllegalStateException("입력을 받을 수 없습니다.");
    }
}

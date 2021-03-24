package calculator.domain;

import java.util.Arrays;

public class Calculator {
    private Calculator() {

    }

    private static class LazyHolder {
        public static final Calculator INSTANCE = new Calculator();
    }

    public static Calculator getInstance() {
        return LazyHolder.INSTANCE;
    }

    public int calculate(Expression expression) {
        return Arrays.stream(expression.array())
                .mapToInt(this::toNumber)
                .peek(this::assurePositive)
                .sum();
    }

    public int toNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값을 입력할 수 없습니다.");
        }
    }

    public void assurePositive(int number) {
        if (number < 0) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
    }

}

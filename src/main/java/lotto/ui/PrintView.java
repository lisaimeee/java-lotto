package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoReport;
import lotto.domain.Winnings;

import java.util.List;

public class PrintView {
    private static final String ASK_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.\n";
    private static final String SHOW_PURCHASED_LOTTO_AMOUNT = "%d개를 구매했습니다.\n";
    private static final String ASK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.\n";
    private static final String SHOW_LOTTO_REPORT = "당첨통계\n---------\n";
    private static final String SHOW_TOTAL_YIELD = "총 수익률은 %s입니다.";
    private static final int YIELD_TIP_THRESHOLD = 1;
    private static final String SHOW_TOTAL_YIELD_TIP = String.format("(기준이 %d이기 때문에 결과적으로 손해라는 의미임)",
            YIELD_TIP_THRESHOLD);

    private PrintView() {

    }

    public static void askPurchaseAmountMessage() {
        System.out.print(ASK_PURCHASE_AMOUNT);
    }

    public static void showPurchasedLotto(List<Lotto> lottos) {
        showPurchasedLottoAmount(lottos.size());
        for(Lotto lotto: lottos){
            System.out.print(formatLotto(lotto));
        }
        System.out.println();
    }

    private static void showPurchasedLottoAmount(int count) {
        System.out.printf(SHOW_PURCHASED_LOTTO_AMOUNT, count);
    }

    static String formatLotto(Lotto lotto) {
        String lottoCsv = String.valueOf(lotto.numbers.get(0));
        for (int i = 1; i < lotto.numbers.size(); i++) {
            lottoCsv += "," + lotto.numbers.get(i);
        }
        return String.format("[%s]\n", lottoCsv);
    }

    public static void askWinningNumber() {
        System.out.print(ASK_WINNING_NUMBER);
    }

    public static void showLottoReport(LottoReport lottoReport) {
        System.out.println();
        System.out.print(SHOW_LOTTO_REPORT);
        System.out.print(formatLottoReport(lottoReport));
        System.out.printf(SHOW_TOTAL_YIELD, lottoReport.yield());
        if (isYieldTipVisible(lottoReport.yield())) {
            System.out.print(SHOW_TOTAL_YIELD_TIP);
        }
    }

    private static String formatLottoReport(LottoReport lottoReport) {
        StringBuilder builder = new StringBuilder();

        for (Winnings winnings : Winnings.values()) {
            builder.append(formatWinningMetric(winnings, lottoReport));
        }

        return builder.toString();
    }

    private static boolean isYieldTipVisible(double yield) {
        return yield < YIELD_TIP_THRESHOLD;
    }

    static String formatWinningMetric(Winnings winnings, LottoReport report) {
        return String.format("%d개 일치 (%d)- %d개\n", winnings.matched, winnings.winnings, report.countWinnings(winnings));
    }

}

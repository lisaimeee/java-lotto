package lotto;

import java.util.List;

public class LottoController {
    public static void main(String[] args){
        String amount = InputView.getLottoPurchaseAmount();
        List<Lotto> lottos = LottoStore.issue(amount);
        ResultView.printLottoPurchased(lottos);
        String winningNumber = InputView.getLastWeekWinningNumber();
        Lotto winning = Lotto.of(winningNumber);
        WinningStatistics statistics = new WinningStatistics(winning, lottos);
        ResultView.printWinningStatistics(statistics);
    }
}

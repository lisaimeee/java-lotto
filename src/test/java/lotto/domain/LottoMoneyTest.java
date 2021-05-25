package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMoneyTest {
    @Test
    void 금액이_동일한_LottoMoney_는_서로_같다() {
        assertThat(new LottoMoney(1000)).isEqualTo(new LottoMoney(1000));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, 50, -1})
    void 로또구입금액은_1_000원_보다_작을_수_없다(int lessThanALottoPrice) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMoney(lessThanALottoPrice))
                .withMessage("로또 최소 구매액은 1000원 입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {680001, 1050, 1500})
    void 로또구입금액은_1_000원_단위여야_한다(int invalidMoneyUnit) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMoney(invalidMoneyUnit))
                .withMessage("로또는 1000원 단위로 구매할 수 있습니다");
    }
}

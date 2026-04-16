import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BettingAmountTest {

    @ParameterizedTest
    @DisplayName("배팅 금액이 공백일 경우 예외 발생")
    @ValueSource(strings = {"", " "})
    void createBettingAmount_fail_when_empty_amount(String emptyAmount) {
        // when & then
        assertThatThrownBy(() -> new BettingAmount(emptyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 배팅 금액은 공백일 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("배팅 금액이 숫자 타입이 아닐 경우 예외 발생")
    @ValueSource(strings = {"string", "!@#$"})
    void createBettingAmount_fail_when_not_integer_amount(String invalidAmount) {
        // when & then
        assertThatThrownBy(() -> new BettingAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 배팅 금액은 숫자 형태로 입력해야 합니다.");
    }
}

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BettingAmount {

    @ParameterizedTest
    @DisplayName("입력값이 공백일 경우 예외 발생")
    @ValueSource(strings = {"", " "})
    void createBettingAmount_fail_when_empty_input(String emptyInput) {
        // when & then
        Assertions.assertThatThrownBy(() -> new BettingAmount(emptyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 배팅 금액은 공백일 수 없습니다.");
    }
}

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CommaSplitterTest {

    @ParameterizedTest
    @DisplayName("입력값이 공백일 경우 예외 발생")
    @ValueSource(strings = {"", " "})
    void nameSplit_fail_when_empty_input(String input) {
        // when & then
        Assertions.assertThatThrownBy(() -> CommaSplitter.split(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값은 공백일 수 없습니다.");
    }
}

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @ParameterizedTest
    @DisplayName("올바른 형식의 입력값일 경우 쉼표로 구분하고, 구분한 문자열들의 개수가 옳아야 한다.")
    @CsvSource(value = {
            "'pobi,jason', 2",
            "'pobi,jason,ever', 3",
            "'pobi', 1"
    })
    void nameSplit_success(String input, int nameCount) {
        // when
        List<String> names = CommaSplitter.split(input);

        // then
        assertEquals(nameCount, names.size());
    }
}

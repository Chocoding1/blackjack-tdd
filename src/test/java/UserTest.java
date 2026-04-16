import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @ParameterizedTest
    @DisplayName("사용자의 이름이 공백일 경우 예외 발생")
    @ValueSource(strings = {"", " "})
    void createUser_fail_when_empty_name(String emptyName) {
        // when & then
        assertThatThrownBy(() -> new User(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자의 이름은 공백일 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("사용자의 이름에 특수문자가 존재할 경우 예외 발생")
    @ValueSource(strings = {"pobi*", "po bi", "pobi123"})
    void createUser_fail_when_name_contains_invalid_string(String invalidName) {
        // when & then
        assertThatThrownBy(() -> new User(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자의 이름은 영어 또는 한글로만 입력할 수 있습니다.(띄어쓰기 불가)");
    }
}

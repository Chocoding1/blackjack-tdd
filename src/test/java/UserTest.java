import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {

    @ParameterizedTest
    @DisplayName("사용자의 이름이 공백일 경우 예외 발생")
    @ValueSource(strings = {"", " "})
    void createUser_fail_when_empty_name(String emptyName) {
        // when
        Assertions.assertThatThrownBy(() -> new User(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자의 이름은 공백일 수 없습니다.");
    }
}

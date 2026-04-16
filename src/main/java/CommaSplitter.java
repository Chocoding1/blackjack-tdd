import java.util.Arrays;
import java.util.List;

public class CommaSplitter {

    private static final String COMMA = ",";

    private static final String ERROR_EMPTY_INPUT = "[ERROR] 입력값은 공백일 수 없습니다.";

    public static List<String> split(String input) {
        validateEmptyInput(input);

        return Arrays.stream(input.split(COMMA))
                .toList();
    }

    private static void validateEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }
}

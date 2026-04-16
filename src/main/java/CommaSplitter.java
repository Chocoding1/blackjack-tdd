import java.util.Arrays;
import java.util.List;

public class CommaSplitter {

    public static List<String> split(String input) {
        validateEmptyInput(input);

        return Arrays.stream(input.split(","))
                .toList();
    }

    private static void validateEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 공백일 수 없습니다.");
        }
    }
}

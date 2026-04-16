public class CommaSplitter {

    public static void split(String input) {
        validateEmptyInput(input);
    }

    private static void validateEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 공백일 수 없습니다.");
        }
    }
}

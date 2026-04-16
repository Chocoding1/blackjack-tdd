public class User {

    private static final String NAME_REGEX = "^[a-zA-Z가-힣]+$";

    private static final String ERROR_EMPTY_NAME = "[ERROR] 사용자의 이름은 공백일 수 없습니다.";
    private static final String ERROR_INVALID_NAME_REGEX = "[ERROR] 사용자의 이름은 영어 또는 한글로만 입력할 수 있습니다.(띄어쓰기 불가)";

    private final String name;

    public User(String name) {
        validateEmpty(name);
        validateInvalidFormat(name);
        this.name = name.strip();
    }

    private void validateEmpty(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
    }

    private void validateInvalidFormat(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException(ERROR_INVALID_NAME_REGEX);
        }
    }
}

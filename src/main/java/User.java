public class User {

    private final String name;

    public User(String name) {
        validateEmpty(name);
        this.name = name.strip();
    }

    private void validateEmpty(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 사용자의 이름은 공백일 수 없습니다.");
        }
    }
}

public enum Rank {

    ACE(1, "1"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "$"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    J(10, "10"),
    Q(10, "10"),
    K(10, "10"),
    ;

    private final int score;
    private final String format;

    Rank(int score, String format) {
        this.score = score;
        this.format = format;
    }

    public int getScore() {
        return score;
    }
}

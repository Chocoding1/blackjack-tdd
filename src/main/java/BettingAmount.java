public class BettingAmount {

    private final int amount;

    public BettingAmount(String input) {
        validateEmpty(input);
        int amount = convertToInt(input);
        validateRange(amount);
        this.amount = amount;
    }

    private void validateEmpty(String amount) {
        if (amount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 배팅 금액은 공백일 수 없습니다.");
        }
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 배팅 금액은 숫자 형태로 입력해야 합니다.");
        }
    }

    private void validateRange(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 배팅 금액은 0보다 커야 합니다.");
        }
    }
}

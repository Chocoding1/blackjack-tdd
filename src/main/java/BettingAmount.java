public class BettingAmount {

    private final String amount;

    public BettingAmount(String amount) {
        validateEmpty(amount);
        this.amount = amount;
    }

    private void validateEmpty(String amount) {
        if (amount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 배팅 금액은 공백일 수 없습니다.");
        }
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @ParameterizedTest
    @DisplayName("2 ~ 9 Rank는 각각 2 ~ 9의 점수를 반한다.")
    @CsvSource({
            "TWO, 2",
            "THREE, 3",
            "FOUR, 4",
            "FIVE, 5",
            "SIX, 6",
            "SEVEN, 7",
            "EIGHT, 8",
            "NINE, 9"
    })
    void rankScoreTest(Rank rank, int expectedScore) {
        // when & then
        Assertions.assertEquals(expectedScore, rank.getScore());
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(expectedScore, rank.getScore());
    }

    @Test
    @DisplayName("ACE Rank는 1의 점수를 반환한다.")
    void aceRankScoreTest() {
        // given
        Rank rank = Rank.ACE;
        int expectedScore = 1;

        // when & then
        assertEquals(expectedScore, rank.getScore());
    }

    @ParameterizedTest
    @DisplayName("J, Q, K Rank는 10의 점수를 반환한다.")
    @CsvSource({
            "J, 10",
            "Q, 10",
            "K, 10"
    })
    void tenRankScoreTest(Rank rank, int expectedScore) {
        // when & then
        assertEquals(expectedScore, rank.getScore());
    }
}

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {

    @Test
    @DisplayName("Card는 Rank와 Suit을 파라미터로 받아 생성된다.")
    void createCard_success() {
        // given
        Card card = new Card(Rank.ACE, Suit.CLOVER);

        // when & then
        assertThat(card).isNotNull();
    }

    @Test
    @DisplayName("Card는 Rank와 Suit이 같으면 같은 객체이다.")
    void card_equalsAndHashCode_test() {
        // given
        Card card1 = new Card(Rank.ACE, Suit.CLOVER);
        Card card2 = new Card(Rank.ACE, Suit.CLOVER);

        // when & then
        assertThat(card1).isEqualTo(card2);
    }
}

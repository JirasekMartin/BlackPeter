// Balíček karet
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private List<Card> cards;

    public CardDeck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffleCards() {
        if (!isDeckEmpty())
            Collections.shuffle(cards);
    }

    private boolean isDeckEmpty() {
        return cards == null || cards.isEmpty();
    }

    public Card drawCard() {
        Card card = null;
        if (!isDeckEmpty()) {
            card = cards.get(0); // vyjmeme první kartu
            cards.remove(card); // odstraníme kartu z balíčku
        }
        return card;
    }
}
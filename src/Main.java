import java.util.ArrayList;
import java.util.List;
// Spouštěcí třída
public class Main {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        int cardCount = 32;
        int pairsCount = cardCount / 2;
        for (int i = 0; i < pairsCount; i++) {
            cards.add(new Card(i, i));
            cards.add(new Card(i, i));
        }
        CardDeck cardDeck = new CardDeck(cards);
        GameControl gameControl = new GameControlImpl();
        Game game = new Game(cardDeck, gameControl.selectNumberOfPlayers(), gameControl);
        game.start();
    }
}
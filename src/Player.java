// Hráč
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void removePairsFromHand() {
        List<Card> pairsToRemove = new ArrayList<>();
        for (Card card : hand) {
            try {
                for (Card c : hand) {
                    if (card.getPairNumber() == c.getPairNumber() && card.getCardNumber() != c.getCardNumber()) {
                        pairsToRemove.add(card);
                        pairsToRemove.add(c);
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        hand.removeAll(pairsToRemove);
    }
}
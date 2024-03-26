import java.util.ArrayList;
import java.util.List;

public class Game {
    private CardDeck cardDeck;
    private int numberOfPlayers;
    private List<Player> players;
    private GameControl gameControl;
    private boolean gameOver;

    public Game(CardDeck cardDeck, int numberOfPlayers, GameControl gameControl) {
        this.cardDeck = cardDeck;
        this.numberOfPlayers = numberOfPlayers;
        this.players = new ArrayList<>();
        this.gameControl = gameControl;
        this.gameOver = false; // Nastavíme počáteční stav hry
    }

    public void start() {
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(gameControl.getPlayerName(i));
        }

        cardDeck.shuffleCards();

        dealCards();

        while (!gameOver) {
            playRound();
        }

        gameControl.displayLoser(this);
    }

    private void dealCards() {
        int numberOfCardsToDeal = cardDeck.getCards().size() / numberOfPlayers;
        for (Player player : players) {
            for (int i = 0; i < numberOfCardsToDeal; i++) {
                player.getHand().add(cardDeck.drawCard());
            }
        }
    }

    private void playRound() {
        for (Player player : players) {
            if (!gameOver) {
                Player opponent = getOpponent(player);
                int cardToTake = gameControl.takeCard(player, opponent);

                // Kontrola platnosti indexu karty
                if (cardToTake >= 0 && cardToTake < opponent.getHand().size()) {
                    Card card = opponent.getHand().get(cardToTake);
                    player.getHand().add(card);
                    opponent.getHand().remove(cardToTake);
                    player.removePairsFromHand();

                    // Aktualizace stavu hry po každém kole
                    gameOver = isGameOver();
                } else {
                    System.out.println("Neplatný index karty, kterou chcete vzít od protihráče.");
                }
            }
        }
    }

    private boolean isGameOver() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private Player getOpponent(Player currentPlayer) {
        for (Player player : players) {
            if (!player.equals(currentPlayer)) {
                return player;
            }
        }
        return null;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
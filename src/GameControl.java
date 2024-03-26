
public interface GameControl {
    int selectNumberOfPlayers();

    Player getPlayerName(int i);

    int takeCard(Player player1, Player player2);

    void displayLoser(Game game);
}
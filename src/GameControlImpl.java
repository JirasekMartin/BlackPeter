import java.util.Scanner;

public class GameControlImpl implements GameControl {
    Scanner scanner = new Scanner(System.in);

    @Override
    public int selectNumberOfPlayers() {
        int numberOfPlayers = 0;

        System.out.println("Enter the number of players (3 to 6):");

        try {
            numberOfPlayers = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception ex) {
            System.out.println("Failed to read the number of players. Did you enter a correct number?");
            numberOfPlayers = selectNumberOfPlayers();
        }

        return numberOfPlayers;
    }

    @Override
    public Player getPlayerName(int i) {
        Player player = null;
        System.out.println("Enter the name for player " + i + ":");
        String name = scanner.next();
        scanner.nextLine();
        if (name.equals("") || name.equals(" ")) {
            System.out.println("Please enter the name for player " + i + " again:");
            player = getPlayerName(i);
        } else {
            player = new Player(name);
        }
        return player;
    }

    @Override
    public int takeCard(Player player1, Player player2) {
        int cardToTake = 0;
        System.out.print(player1.getName() + ", which card do you want to take from " + player2.getName() + "?: ");
        for (int i = 0; i < player2.getHand().size(); i++) {
            System.out.print(i + ", ");
        }
        try {
            cardToTake = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception ex) {
            System.out.println("Failed to get which card you want to take. Did you enter the correct number?");
            cardToTake = takeCard(player1, player2);
        }
        return cardToTake;
    }

    @Override
    public void displayLoser(Game game) {
        System.out.println("Black Peter is " + game.getPlayers().get(0).getName());
        scanner.close();
    }
}
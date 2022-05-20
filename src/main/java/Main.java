import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");

        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        Ship.placeShip();

        player.makeTurn(playerName);
    }
}
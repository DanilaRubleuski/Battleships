import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {
    private static String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }
    public static String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        Player.playerName = playerName;
    }

    public void makeTurn(String playerName) {

        while (!Game.isWinCondition()) {
            Scanner scanner = new Scanner(System.in);
            //Getting input command
            System.out.println("\n"+playerName + ", please, make your turn.");
            Battlefield.drawMonitor();
            System.out.println("Please enter hit coordinates:");
            Pattern inputPattern = Pattern.compile("[A-Z]\\d0?+");
            String coordinates = null;
            //Parsing hit coordinate according to the pattern
            try {
                coordinates = scanner.next(inputPattern);
            } catch (Exception e) {
                System.out.println("Wrong coordinate format");
                continue;
            }
            //Receiving x-axis and y-axis from the coordinate
            ArrayList<String> allMatches = splitCoordinates(coordinates);
            //Check where did the bomb hit
            int x = Battlefield.fillNotation().get(allMatches.get(0));
            int y = Integer.parseInt(allMatches.get(1));
            if (Battlefield.battlefield[x-1][y-1] == 1) {
                System.out.println("Hit!");
                Battlefield.monitor[x-1][y-1] = 2;
                Ship.hit(x-1,y-1);
            }
            else {
                System.out.println("Miss! Try again");
                Battlefield.monitor[x-1][y-1] = 1;
            }
        }
    }
    public ArrayList<String> splitCoordinates(String coordinates){
        Pattern splitPattern = Pattern.compile("[A-Z]|\\d+");
        Matcher m = splitPattern.matcher(coordinates);
        ArrayList<String> allMatches = new ArrayList<>();
        while (m.find()) {
            allMatches.add(m.group());
        }
        return allMatches;
    }
}

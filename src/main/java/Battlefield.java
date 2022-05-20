import java.util.HashMap;
import java.util.Map;

public class Battlefield {
    //Computer's view on the field
    static int[][] battlefield = new int[10][10];
    //Player's view on the field
    static int[][] monitor = new int[10][10];
    //Field markings
    static final String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
    static final int[] numbers = {1,2,3,4,5,6,7,8,9,10};
    public static Map<String,Integer> fillNotation(){
        Map<String,Integer> lettersNumbers = new HashMap<>();
        for(int i = 0;i<numbers.length;i++){
            lettersNumbers.put(letters[i],numbers[i]);
        }
        return lettersNumbers;
    }
    public static void drawShip(Ship ship,int[][] canvas){

        for (int i = 0; i < ship.getSize(); i++) {
            if (ship.getDirection() == 0) {
                canvas[ship.getStart().getX()][ship.getStart().getY() + i] = 1;
            } else {
                canvas[ship.getStart().getX() + i][ship.getStart().getY()] = 1;
            }
        }
    }
    public static void drawField() {
        System.out.println("\tA B C D E F G H I J");
        for (int i = 0; i < battlefield.length; i++) {
            System.out.print(i+1 + "\t");
            for (int j = 0; j < battlefield[1].length; j++) {
                if (battlefield[j][i] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
    public static void drawMonitor(){
        System.out.println("\tA B C D E F G H I J");
        for (int i = 0; i < Battlefield.monitor.length; i++) {
            System.out.print(i+1 + "\t");
            for (int j = 0; j < Battlefield.monitor[1].length; j++) {
                if (Battlefield.monitor[j][i] == 0) {
                    System.out.print("- ");
                } else if (Battlefield.monitor[j][i] == 1) {
                    System.out.print("o ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}

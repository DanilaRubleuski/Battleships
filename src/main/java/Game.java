public class Game {

    public static boolean isAvailable(int x, int y, int size, int rotation, int[][] battlefield) {
       //Out of field bounds
        if (rotation == 0) {
            if (y + size > battlefield.length) {
                return false;
            }
        }
        if (rotation == 1){
            if (x + size > battlefield[0].length){
                return false;
            }
        }
        while (size!=0){
            for (int i = 0; i < size; i++) {
                int xi = 0;
                int yi = 0;
                if (rotation == 0){
                    yi = i;
                } else{
                    xi = i;
                }
                //Ships collision
                if (x + 1 + xi < battlefield.length && x + 1 + xi >= 0){
                    if (battlefield[x + 1 + xi][y + yi]!=0){
                        return false;
                    }
                }
                if (x - 1 + xi < battlefield.length && x - 1 + xi >= 0){
                    if (battlefield[x - 1 + xi][y + yi]!=0){
                        return false;
                    }
                }
                if (y + 1 + yi < battlefield.length && y + 1 + yi >= 0){
                    if (battlefield[x + xi][y + 1 + yi]!=0){
                        return false;
                    }
                }
                if (y - 1 + yi < battlefield.length && y - 1 + yi >= 0){
                    if (battlefield[x + xi][y - 1 + yi]!=0){
                        return false;
                    }
                }
            }
            size--;
        }
        return true;
    }
    public static boolean isWinCondition() {
        if (Ship.ships.isEmpty()) {
            System.out.println(Player.getPlayerName() + " win!!!");
            return true;
        }
        return false;
    }
}

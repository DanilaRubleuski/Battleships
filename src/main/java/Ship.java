import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Random;

public class Ship {
    private int size;
    private Point start;
    private Point end;
    private int lives;
    private int direction;
    public static ArrayList<Ship> ships = new ArrayList<>();

    public Ship(int size, Point start, Point end, int direction){
        this.size = size;
        this.start = start;
        this.end = end;
        this.direction = direction;
        this.lives = this.size;

    }
    public int getSize() {
        return size;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }
    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
    public static void placeShip() {
        createShip(5,1);
        createShip(4,2);
        //You can watch the computer has arranged the ships by calling the function
        Battlefield.drawField();
    }
    public static void createShip(int size, int shipsNumber){
        Random rand;
        while (shipsNumber>0) {
            rand = new Random();
            //Generated ship position
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            int direction = rand.nextInt(2);
            if (!Game.isAvailable(x, y, size, direction, Battlefield.battlefield)){
                continue;
            }
            //Create and add generated ship to the fleet
            Point start = new Point(x,y);
            Point end;
            if(direction == 0)
                end = new Point(x,y+size-1);
            else
                end = new Point(x+size-1,y);

            Ship ship = new Ship(size,start,end,direction);
            ships.add(ship);
            Battlefield.drawShip(ship,Battlefield.battlefield);

            shipsNumber--;
        }
    }
     public static boolean isOnShip(Ship ship, int x, int y)
    {
        if (x>=Math.min(ship.start.getX(),ship.end.getX()) && x<=Math.max(ship.start.getX(),ship.end.getX()) &&
                y>=Math.min(ship.start.getY(),ship.end.getY()) && y<=Math.max(ship.start.getY(),ship.end.getY())){
            return true;
        }
        return false;
    }
    public static void hit(int x ,int y){

        for (Ship ship : ships){
            //Bomb hit the ship
            if(isOnShip(ship,x,y)){
                ship.lives--;
            }
            if(!isAlive(ship)){
                System.out.println("The battleship is sink!!!");
                ships.remove(ship);
                return;
            }
        }
    }
    public static boolean isAlive(Ship ship) {
        return ship.lives > 0;
    }
}

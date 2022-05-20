class Point implements Comparable<Point>{
    private int x;
    private int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    @Override
    public int compareTo(Point p) {
        return Integer.compare(x, p.getX());
    }
    @Override
    public String toString() {
        return x + "," + y;
    }
}

package Learning.company;

public class Point {
    private int x;
    private int y;
    public Point() {
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }
    public double distance() {
        return Math.sqrt((0 - this.x) * (0 - this.x) + (0 - this.y) * (0 - this.y));
    }
    public double distance(int x, int y) {
        return Math.sqrt((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y));
    }
    public double distance(Point another) {
        return Math.sqrt(((another.getX()) - this.x) * ((another.getX()) - this.x) + ((another.getY()) - this.y) * ((another.getY()) - this.y));
    }

}



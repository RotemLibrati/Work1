package utilities;

public class Point {
    final double x;
    final double y;

    public Point(double x, double y) {
        if (x >= 0 && x <= 1000000) this.x = x;
        else this.x = 0;
        if (y >= 0 && y <= 800) this.y = y;
        else this.y = 0;
    }
    //getters
    public double getX() {
        return x;
    }
    public double getY() { return y; }
    public String toString(){
        return getClass().getName() + '@' + Integer.toHexString(hashCode());
    }

    public boolean equals(Object other) {
        if (other instanceof Point) {
            return x == ((Point) other).x && y == ((Point) other).y;
        }
        return false;
    }
}

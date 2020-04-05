package utilities;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        if (x>=0 && x<=1000000) this.x = x;
        else this.x=0;
        if (y>=0 && y<=800) this.y = y;
        else this.y=0;
    }
    //getters
    public double getX() {
        return x;
    }
    public double getY() { return y; }

    public String toString(){
        return String.valueOf('(' +   x + ',' + y + ')');
    }

    public boolean equals(Object o){
        if (o==this)
            return true;
        if (!(o instanceof Point))
            return false;
        Point p = (Point)o;
        return Double.compare(x,p.x) == 0 && Double.compare(y,p.y) == 0;
    }
}

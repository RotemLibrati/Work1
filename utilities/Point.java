package utilities;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public void SetX(double x){
        this.x=x;
    }
    public void SetY(double y){
        this.y=y;
    }
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

    public static void main(String[] args) {
        Point p = new Point(3,4);
        p.getY();
    }
}

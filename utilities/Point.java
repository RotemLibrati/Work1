/*Yehonatan Hen-207630112
 * Rotem Librati-307903732
 */
package utilities;

import java.util.Random;

public class Point {
    double x;
    double y;

    public Point(final double x,final double y) {
        if (x >= 0 && x <= 1000000) this.x = x;
        else
        {
            double newX =getRandomDoubleBetweenRange(1,1000000);
            setX(newX);
            System.out.println("The value " + x + " is illegal forX, therefore has been replaced with " + newX );
        }
        if (y >= 0 && y <= 800) this.y = y;
        else
        {
            double newY =getRandomDoubleBetweenRange(1,800);
            setY(newY);
            System.out.println("The value " + y + " is illegal forY, therefore has been replaced with " + newY );
        }
            System.out.println(this.toString() + " has been created");
    }
    //getters
    public double getX() {
        return x;
    }
    public double getY() { return y; }
    //setters
    public void setX(double x)
    {
        if(x >= 0 && x <= 1000000)
            this.x = x;
        else
            System.out.println("The value " + x + " is illegal for x");
    }
    public void setY(double y)
    {
        if(y >= 0 && y <= 800)
            this.y = y;
        else
            System.out.println("The value " + y + " is illegal for y");
    }

    public String toString(){
        return  "Point ("+ getX() + " , "+ getY() + ")";
    }
    public boolean equals(Object other) {
        if (other instanceof Point) {
            return x == ((Point) other).x && y == ((Point) other).y;
        }
        return false;
    }

    public static double getRandomDoubleBetweenRange(final double min,final double max){
        //Function return randomal double between min to max
        double x = (Math.random()*((max-min)+1))+min;
        return x;
    }

}


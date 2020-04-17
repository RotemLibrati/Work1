/*Yehonatan Hen-207630112
 *Rotem Librati-307903732
 */
package components;

import utilities.Point;

import java.util.ArrayList;
import java.util.Random;

public class VehicleType {
    //Class make vehicle type attributes
    String typeName;
    int speed; // average speed of vehicle type


    public VehicleType(final String name,final int speed)
    {
        this.typeName = name;
        this.speed = speed;
    }
    public String toString()
    {
        return getTypeName() + ", average speed: " + getSpeed();
    }

    public boolean equals(Object other) {
        if (other instanceof VehicleType) {
            return typeName == ((VehicleType) other).typeName && speed == ((VehicleType) other).speed;
        }
        return false;
    }
    //getters

    public int getSpeed() {
        return speed;
    }

    public String getTypeName() {
        return typeName;
    }

    public static ArrayList<VehicleType> getRandomVehicleTypes()
            //Function return randomal Array list of vehicle types.
    {
        ArrayList<VehicleType> allowedVehicles;
        allowedVehicles = new ArrayList<VehicleType>();
        Random random = new Random();
        int length = random.nextInt(7)+2;
        for( int i=0;i<length; i++) {
            boolean flag0=true,flag1=true,flag2=true,flag3=true,flag4=true,flag5=true, flag6=true;
            Random rand = new Random();
            int x = rand.nextInt(7);
            if (x == 0 && flag0 == true) {
                allowedVehicles.add(new VehicleType("Bicycle", 40));
                flag0=false;
            } else if (x == 1 && flag1 == true) {
                allowedVehicles.add(new VehicleType("Tram", 50));
                flag1 = false;
            }
            if (x == 2 && flag2 == true) {
                allowedVehicles.add(new VehicleType("Bus", 60));
                flag2=false;
            } else if (x == 3 && flag3 == true){
                allowedVehicles.add(new VehicleType("Car", 90));
                flag3=false;}
            else if (x == 4 && flag4 == true) {
                allowedVehicles.add(new VehicleType("Semitrailer", 80));
                flag4 = false;
            }
            else if (x == 5 && flag5 == true) {
                allowedVehicles.add(new VehicleType("Truck", 80));
                flag5 = false;
            }
            else if (x == 6 && flag6 == true){
                allowedVehicles.add(new VehicleType("MotorCycle", 120));
                    flag6=false;}
            else{
                i--;
            }
        }
        return allowedVehicles;
    }

}

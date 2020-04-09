package components;

import utilities.Point;

import java.util.ArrayList;
import java.util.Random;

public class VehicleType {
    String typeName;
    int speed; // average speed of vehicle type


    public VehicleType(String name, int speed)
    {
        this.typeName = name;
        this.speed = speed;
    }
    public String toString()
    {
        return getClass().getName() + '@' + Integer.toHexString(hashCode());
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

    public ArrayList<VehicleType> getRandomVehicleTypes()
    {
        ArrayList<VehicleType> allowedVehicles;
        allowedVehicles = new ArrayList<VehicleType>();
        Random random = new Random();
        int length = random.nextInt(7);
        for( int i=0;i<length; i++) {
            boolean flag=true;
            Random rand = new Random();
            int x = rand.nextInt(7);
            if (x == 0 && flag == true) {
                allowedVehicles.add(new VehicleType("Bicycle", 40));
                flag=false;
            } else if (x == 1 && flag == true) {
                allowedVehicles.add(new VehicleType("Tram", 50));
                flag = false;
            }
            if (x == 2 && flag == true) {
                allowedVehicles.add(new VehicleType("Bus", 60));
                flag=false;
            } else if (x == 3 && flag == true){
                allowedVehicles.add(new VehicleType("Car", 90));
                flag=false;}
            else if (x == 4 && flag == true) {
                allowedVehicles.add(new VehicleType("Semitrailer", 80));
                flag = false;
            }
            else if (x == 5 && flag == true) {
                allowedVehicles.add(new VehicleType("Truck", 80));
                flag = false;
            }
            else if (x == 6 && flag == true){
                allowedVehicles.add(new VehicleType("MotorCycle", 120));
                    flag=false;}
        }
        return allowedVehicles;
    }
}

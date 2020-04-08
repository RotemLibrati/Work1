package components;

import utilities.Point;

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
}

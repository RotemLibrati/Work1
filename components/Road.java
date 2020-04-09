package components;

import utilities.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Road {
    private Junction fromJunc;
    private Junction toJunc;
    private ArrayList<VehicleType> allowedVehicles;  // holds the list of vehicle types
    //that are allowed to move on the road.
    private boolean isOpen;  // True when the light is green.
    private boolean isEnabled; // appears on the map
    private double length;  // the distance between the two junctions
    private int maxSpeed;


    public Road(Junction from, Junction to) {
        /*creates an instance of the
          class and sets the values of allowedVehicles, isOpen and isEnabled
          randomly. Sets the length value to the calculated one*/
        String[] vehicleTypes = new String[]{"Ambulance", "Police", "Bus", "Private", "FireTruck", "Truck", "MotorCycle"};
        allowedVehicles = new ArrayList<VehicleType>();
        Random rand = new Random();
        //Random 5 values from the vehicleTypes array and put then into allowedVehicles
        for (int i = 0; i < 5; i++) {
            allowedVehicles.add(new VehicleType(vehicleTypes[rand.nextInt(vehicleTypes.length)],0));
        }
        //Random true/false
        isEnabled = rand.nextBoolean();
        isOpen = rand.nextBoolean();
        fromJunc = from;
        toJunc = to;
        length = countLength();
        maxSpeed = 0;

    }

    public Road(Junction from, Junction to, ArrayList<VehicleType> allowed, boolean open, boolean enabled) {
        fromJunc = new Junction(from.getJunctionName(),new Point(from.getLocation().getX(),from.getLocation().getY()));
        toJunc = new Junction(to.getJunctionName(),new Point(to.getLocation().getX(),to.getLocation().getY()));
        allowedVehicles = new ArrayList<VehicleType>();
        allowedVehicles.addAll(allowed);
        isOpen = open;
        isEnabled = enabled;
        fromJunc = from;
        toJunc = to;
        length = countLength();
        maxSpeed = 0;
    }

    //getters
    public Junction getFromJunc() {
        return fromJunc;
    }

    public Junction getToJunc() {
        return toJunc;
    }

    public ArrayList<VehicleType> getAllowedVehicle() {
        return allowedVehicles;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public double getLength() {
        return length;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    //setters
    public void setFromJunc(Junction from) {
        fromJunc = from;
    }

    public void setToJunc(Junction to) {
        toJunc = to;
    }

    public void setAllowedVehicles(ArrayList<VehicleType> allowed) {
        allowedVehicles.addAll(allowed);
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void addVehicleType(String type) {
        //Function add new vehicle type to allowed vehicles ArrayList
        allowedVehicles.add(new VehicleType(type,0));
    }

    public double countLength() {
        //calculates the length of the road using the coordinates of its junctions
        return Math.sqrt(Math.pow(fromJunc.getLocation().getX() - toJunc.getLocation().getX(), 2) -
                Math.pow(fromJunc.getLocation().getY() - toJunc.getLocation().getY(), 2));
    }

    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(hashCode());
    }

    public boolean equals(Object other) {
        if (other instanceof Road) {
            return fromJunc.equals(((Road) other).fromJunc) &&
                    toJunc.equals(((Road) other).toJunc) &&
                    allowedVehicles == ((Road) other).allowedVehicles &&
                    isOpen == ((Road) other).isOpen &&
                    isEnabled == ((Road) other).isEnabled &&
                    length == ((Road) other).length &&
                    maxSpeed == ((Road) other).maxSpeed;
        }
        return false;
    }
}
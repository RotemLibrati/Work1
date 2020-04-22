
package components;

import utilities.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Class implement a road in the map.
 *  @version 1.0 22.04.2020
 *  @author Yehonatan Hen-207630112
 * @author Rotem Librati-307903732
 *
 * @see Junction
 * @see Route
 * @see Map
 **/
public class Road {
    private Junction fromJunc;
    private Junction toJunc;
    private ArrayList<VehicleType> allowedVehicles;  // holds the list of vehicle types
    //that are allowed to move on the road.
    private boolean isOpen;  // True when the light is green.
    private boolean isEnabled; // appears on the map
    private double length;  // the distance between the two junctions
    private int maxSpeed;


    /**
     * creates an instance of the
     * class and sets the values of allowedVehicles, isOpen and isEnabled
     * randomly. Sets the length value to the calculated one
     *
     * @param from
     * @param to
     */
    public Road(Junction from, Junction to) {
        Random rand = new Random();
        //Set Vehicle Types array
        VehicleType [] arr = {new VehicleType("bus", 60),new VehicleType("motorcycle", 120),new VehicleType("car", 90),
                new VehicleType("truck", 80),new VehicleType("semitrailer",80),new VehicleType("bicycle",40),
                new VehicleType("tram",50)};
        int numOfVehicles=rand.nextInt(arr.length)+2;
        allowedVehicles=new ArrayList<>();
        for (int i=0;i<numOfVehicles;i++){
            allowedVehicles.add(arr[rand.nextInt(arr.length)]);
        }
        isEnabled = rand.nextBoolean();
        isOpen = rand.nextBoolean();
        fromJunc = from;
        toJunc = to;
        length = countLength();
        maxSpeed=(rand.nextInt(12)+2)*10;//Set the value of max-speed between 20-120
        if(!from.getEnteringRoads().contains(this)) to.setEnteringRoad(this);
        if(!to.getExitingRoads().contains(this)) from.setExitingRoad(this);
        fromJunc = from;
        toJunc = to;
    }

    /**
     * Another Road constructor.
     *
     * @param from
     * @param to
     * @param allowed
     * @param open
     * @param enabled
     */
    public Road(Junction from, Junction to, ArrayList<VehicleType> allowed,final boolean open,final boolean enabled) {
        allowedVehicles = new ArrayList<VehicleType>();
        allowedVehicles.addAll(allowed);
        isOpen = open;
        isEnabled = enabled;
        length = countLength();
        Random rand = new Random();
        maxSpeed=(rand.nextInt(12)+2)*10;//Set the value of max-speed between 20-120
        to.setEnteringRoad(this);
        from.setExitingRoad(this);
        fromJunc = from;
        toJunc = to;
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
    public int getEnteringRoads() {return toJunc.sizeOfEnteringRoads();}

    //setters
    public void setFromJunc(final Junction from) {
        fromJunc = from;
    }

    public void setToJunc(final Junction to) {
        toJunc = to;
    }

    public void setAllowedVehicles(ArrayList<VehicleType> allowed) {
        allowedVehicles.clear();
        allowedVehicles.addAll(allowed);
    }

    public void setIsOpen(final boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void setIsEnabled(final boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public void setLength(final double length) {
        this.length = length;
    }

    public void setMaxSpeed(final int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * Function add new vehicle type to allowed vehicles ArrayList
     *
     * @param type
     */
    public void addVehicleType(VehicleType type) {
        allowedVehicles.add(type);
    }


    /**
     * calculates the length of the road using the coordinates of its junctions
     *
     * @return the length of the road.
     */
    public double countLength() {

        return Math.sqrt(Math.pow(fromJunc.getLocation().getX() - toJunc.getLocation().getX(), 2) +
                Math.pow(fromJunc.getLocation().getY() - toJunc.getLocation().getY(), 2));
    }

    public String toString() {
        return "Road from " +  fromJunc.getJunctionName() + " to " + toJunc.getJunctionName();
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
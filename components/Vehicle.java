package components;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.Random;
import java.util.TooManyListenersException;

/**
 * Class implements a vehicle
 *
 *  @version 1.0 22.04.2020
 *  @author Yehonatan Hen-207630112
 * @author Rotem Librati-307903732
 *
 * @see Junction
 * @see Route
 * @see Road
 * @see VehicleType
 * @see Map
 * @see game.Driving
 **/
public class Vehicle {
    private int id;
    private VehicleType type;
    private int speed;  //average speed for this type of vehicle.
    private Route currentRoute;
    private Junction lastJunction; //current junction or last junction where the vehicle visited
    private Road lastRoad;
    private boolean movesNow; //True if the vehicle is on the road between the junctions.
    private double spentTime;  //time passed from the beginning of movement on the route.

    public Vehicle(final int id,final VehicleType type, Junction lastJunction) {
        this.id = id;
        this.type = type;
        speed = type.getSpeed();
        this.lastJunction = lastJunction;
        ArrayList<Junction> juncs = new ArrayList<>();
        juncs.add(lastJunction);
        ArrayList<Road> roads = new ArrayList<>();
        roads.add(lastRoad);
        currentRoute = new Route(juncs, roads, type);
        movesNow = false;
        spentTime = 0;
        System.out.println(this + " has been created and placed at " + lastJunction);
    }

    //getters
    public int getID() {
        return id;
    }

    public VehicleType getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public Route getCurrentRoute() {
        return currentRoute;
    }

    public Junction getLastJunction() {
        return lastJunction;
    }

    public Road getLastRoad() {
        return lastRoad;
    }

    public boolean getMovesNow() {
        return movesNow;
    }

    public double getSpentTime() {
        return spentTime;
    }

    //setters
    public void setID(final int id) {
        this.id = id;
    }

    public void setType(final VehicleType type) {
        this.type = type;
    }

    public void setSpeed(final int speed) {
        this.speed = speed;
    }

    public void setCurrentRoute(final Route currentRoute) {
        this.currentRoute = currentRoute;
    }

    public void setLastJunction(final Junction lastJunction) {
        this.lastJunction = lastJunction;
    }

    public void setLastRoad(final Road lastRoad) {
        this.lastRoad = lastRoad;
    }

    public void setMovesNow(final boolean movesNow) {
        this.movesNow = movesNow;
    }

    public void setSpentTime(final double spentTime) {
        this.spentTime = spentTime;
    }

    /**
     * wait for the current point delay time and move to the next
     * point of the route.
     */
    public void move() {
        int i = 0;
        while (!lastJunction.equals(currentRoute.getJunctions().get(i)) && !lastJunction.equals(currentRoute.getEnd())) {
            i++;
        }
        lastRoad = new Road(lastJunction, currentRoute.getJunctions().get(i + 1));

        //if vehicle is at the start of the route
        if (lastJunction.equals(currentRoute.getStart())) {
            System.out.println(this + " is starting route from " + currentRoute.getStart() + " to " + currentRoute.getEnd());
        }
        //If junction don't have exiting roads
        if (lastJunction.getExitingRoads().size() == 0) {
            System.out.println(this + " stays at " + lastJunction + " - no exiting roads");
            checkIn();
        }
        //if vehicle arrived to last junction of the roads
        else if (lastJunction.equals(currentRoute.getEnd())) {
            System.out.println(this + " has finished the route. Total time:" + spentTime);
        } else {
            //If road isn't available
            if (lastJunction.checkAvailabilty(lastRoad) || !lastJunction.getHasLights()) {
                System.out.println(this + " is waiting for green light at " + lastJunction);
                checkIn();
            }
            //car movement
            else {
                System.out.println(this + " has left " + lastJunction);
                System.out.println(this + " is moving on " + lastRoad + ". Delay time: " + currentRoute.getDelay());
                lastJunction = currentRoute.getJunctions().get(i + 1);
                System.out.println(this + " has arrived to " + lastJunction);
                lastJunction.getVehicles().add(lastRoad);
                spentTime++;
            }

        }

    }

    /**
     * prints the details about the vehicle including current
     * position, time spent on the route and the first and last junctions on the route
     */
    public void status() {
        System.out.println(toString() + " Position: " + lastJunction + " current Route: from" + currentRoute.getStart() +
                " to " + currentRoute.getEnd() + " Time spent:" + String.format("%4f", this.getSpentTime()));
    }

    /**
     * if arrived to a junction, update the junction waiting list
     * and calculate the delay time before the next move.
     */
    public void checkIn() {

        lastJunction.getVehicles().add(lastRoad);
        currentRoute.getRoads().add(lastRoad);
        spentTime += currentRoute.calcDelay();
        lastJunction.setDelay(spentTime);
    }

    public String toString() {
        return type.toString() + ",  ID: " + id;
    }

    public boolean equals(Object other) {
        if (other instanceof Vehicle) {
            return id == ((Vehicle) other).id &&
                    type.equals(((Vehicle) other).type) &&
                    currentRoute.equals(((Vehicle) other).currentRoute) &&
                    lastJunction.equals(((Vehicle) other).lastJunction) &&
                    lastRoad.equals(((Vehicle) other).lastRoad) &&
                    ((Vehicle) other).movesNow == movesNow &&
                    ((Vehicle) other).spentTime == spentTime;
        }
        return false;
    }



}
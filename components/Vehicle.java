/*Yehonatan Hen-207630112
 * Rotem Librati-
 */
package components;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.TooManyListenersException;

public class Vehicle {
    private int id;
    private VehicleType type;
    private int speed;  //average speed for this type of vehicle.
    private Route currentRoute;
    private Junction lastJunction; //current junction or last junction where the vehicle visited
    private Road lastRoad;
    private boolean movesNow; //True if the vehicle is on the road between the junctions.
    private double spentTime;  //time passed from the beginning of movement on the route.

    public Vehicle(int id,VehicleType type, Junction lastJunction){
        this.id=id;
        this.type=type;
        speed=type.getSpeed();
        this.lastJunction=lastJunction;
        ArrayList<Junction> juncs=new ArrayList<>();
        juncs.add(lastJunction);
        ArrayList<Road> roads=new ArrayList<>();
        roads.add(lastRoad);
        currentRoute=new Route(juncs,roads,type);
        spentTime=0;
        movesNow=false;
    }

    //getters
    public int getID(){return id;}
    public VehicleType getType(){return type;}
    public int getSpeed(){return speed;}
    public Route getCurrentRoute(){return currentRoute;}
    public Junction getLastJunction(){return lastJunction;}
    public Road getLastRoad(){return lastRoad;}
    public boolean getMovesNow(){return movesNow;}
    public double getSpentTime(){return spentTime;}

    //setters
    public void setID(final int id){this.id=id;}
    public void setType(final VehicleType type){this.type=type;}
    public void setSpeed(final int speed){this.speed=speed;}
    public void setCurrentRoute(final Route currentRoute){this.currentRoute=currentRoute;}
    public void setLastJunction(final Junction lastJunction){this.lastJunction=lastJunction;}
    public void setLastRoad(final Road lastRoad){this.lastRoad=lastRoad;}
    public void setMovesNow(final boolean movesNow){this.movesNow=movesNow;}
    public void setSpentTime(final double spentTime){this.spentTime=spentTime;}

    public void move() {
    /* wait for the current point delay time and move to the next
    point of the route.*/
        int i=0;
        while(lastJunction.equals(currentRoute.getJunctions().get(i))){
            i++;
        }
        System.out.println(toString()+ " is starting route from "+currentRoute.getJunctions().get(i)+ " to "+ lastJunction);
        lastRoad=new Road(currentRoute.getJunctions().get(i),lastJunction);
        checkIn();
        if(!currentRoute.getJunctions().get(i).getHasLights())
            System.out.println(toString() + " is waiting for green light at Junction " + currentRoute.getJunctions().get(i).getJunctionName());
        else if(currentRoute.getJunctions().get(i).getExitingRoads().size()==0)
            System.out.println(toString()+" stays at "+ currentRoute.getJunctions().get(i).toString()+" - no exiting roads.");
        else{
            System.out.println(toString()+" is moving on "+lastRoad.toString()+" Delay time:"+ String.format("%8f",lastJunction.getDelay()));
        }
    }

    public void status() {
    /*prints the details about the vehicle including current
    position, time spent on the route and the first and last junctions on the route*/
        System.out.println(toString()+" Position: "+lastJunction+" current Route: from"+ currentRoute.getStart()+
                " to "+ currentRoute.getEnd()+ " Time spent:"+ String.format("%8f",this.getSpentTime()));
    }

    public void checkIn(){
     /*if arrived to a junction, update the junction waiting list
      and calculate the delay time before the next move.*/
     lastJunction.getVehicles().add(lastRoad);
     spentTime=currentRoute.calcDelay();
     lastJunction.setDelay(spentTime);
    }

    public String toString(){
        return type.toString()+ ",  ID: "+id;
    }

    public boolean equals(Object other){
        if (other instanceof Vehicle){
            return id==((Vehicle)other).id &&
                type.equals(((Vehicle)other).type) &&
                    currentRoute.equals(((Vehicle)other).currentRoute) &&
                    lastJunction.equals(((Vehicle)other).lastJunction) &&
                    lastRoad.equals(((Vehicle)other).lastRoad) &&
                    ((Vehicle)other).movesNow==movesNow &&
                    ((Vehicle)other).spentTime==spentTime;
        }
        return false;
    }
}
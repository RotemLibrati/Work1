package components;
import utilities.Point;

import java.util.ArrayList;

public class Junction {
    private String junctionName;
    private Point location; // location of the junction on the map
    private ArrayList<Road> enteringRoads;  // holds the list of the roads that enter to the junction.
    private ArrayList<Road> exitingRoads;   // holds the list of the roads that exit the junction.
    private boolean hasLights;  // checks if the junction has traffic lights.
    private int delay;  // delay time in seconds
    private ArrayList<Road> vehicles;  //list of entering roads with cars waiting on the junction

    public Junction(String name,Point loc){
        junctionName=name;
        location=new Point(loc.getX(),loc.getY());
    }
    //getters
    public String getJunctionName(){return junctionName;}
    public Point getLocation(){return location;}
    public ArrayList<Road> getEnteringRoads(){return enteringRoads;}
    public ArrayList<Road> getExitingRoads(){return exitingRoads;}
    public boolean getHasLights(){return hasLights;}
    public int getDelay(){return delay;}
    public ArrayList<Road> getVehicles(){return vehicles;}

    //setters
    public void setJunctionName(final String junctionName){this.junctionName=junctionName;}
    public void setEnteringRoads(final ArrayList<Road>enteringRoads){this.enteringRoads=enteringRoads;}
    public void setExitingRoads(final ArrayList<Road>exitingRoads){this.exitingRoads=exitingRoads;}
    public void setHasLights(final boolean hasLights){this.hasLights=hasLights;}
    public void setDelay(final int delay){this.delay=delay;}
    public void setVehicles(final ArrayList<Road> vehicles){this.vehicles=vehicles;}

    public void changeLight(){
        /*make the next entering road in the list green (open) and
        all the others (exiting only) red (closed).*/

    }

    public boolean checkAvailabilty(Road r){
        /*for vehicle that arrived to the junction
        from road r, checks if there are some other vehicles on the roads with
        a higher traffic priority on the junction.*/

    }

    public String toString(){
        return String.valueOf("name")+location.toString();
    }

    public boolean equals(Object o){
        if (o==this)
            return true;
        if (!(o instanceof Junction))
            return false;
        Junction j = (Junction)o;
        return junctionName==j.junctionName && location.equals(o);
    }
}

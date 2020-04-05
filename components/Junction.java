package components;
import utilities.Point;

import java.util.ArrayList;
import java.util.ListIterator;

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
        enteringRoads=new ArrayList<>();
        exitingRoads=new ArrayList<>();
        vehicles=new ArrayList<>();
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
    public void setEnteringRoads(final ArrayList<Road>enteringRoads){this.enteringRoads.addAll(enteringRoads);}
    public void setExitingRoads(final ArrayList<Road>exitingRoads){this.exitingRoads.addAll(exitingRoads);}
    public void setHasLights(final boolean hasLights){this.hasLights=hasLights;}
    public void setDelay(final int delay){this.delay=delay;}
    public void setVehicles(final ArrayList<Road> vehicles){this.vehicles.addAll(vehicles);}

    public void changeLight(){
        /*make the next entering road in the list green (open) and
        all the others (exiting only) red (closed).*/
        ListIterator<Road> it1=enteringRoads.listIterator();
        ListIterator<Road> it2=exitingRoads.listIterator();
        int i=0;
        while(it1.hasNext()){
            if(!it1.next().getIsOpen()){
                enteringRoads.get(i).setIsOpen(true);
                break;
            }
            i++;
        }
        i=0;
        while(it2.hasNext()){
            exitingRoads.get(i).setIsOpen(false);
            i++;
        }
    }

    public boolean checkAvailabilty(Road r){
        /*for vehicle that arrived to the junction from road r, checks if there
         are some other vehicles on the roads with a higher traffic priority on the junction.*/
        if (vehicles.get(0)==r) return true;
        else{
         for(int i=0;i<vehicles.size() && r!=vehicles.get(i);i++){
             if (vehicles.get(i).getIsOpen()!=true) return false;
         }
         return true;
        }
    }

    public String toString(){
        return getClass().getName()+'@'+Integer.toHexString(hashCode());
    }

    public boolean equals(Object other){
        if (other instanceof Junction){
            return junctionName==((Junction)other).junctionName &&
                    location.equals(((Junction) other).location) &&
                    enteringRoads==((Junction)other).enteringRoads &&
                    exitingRoads==((Junction)other).exitingRoads &&
                    hasLights==((Junction)other).hasLights &&
                    delay==((Junction)other).delay &&
                    vehicles==((Junction)other).vehicles;
        }
        return false;
        /*for vehicle that arrived to the junction
        from road r, checks if there are some other vehicles on the roads with
        a higher traffic priority on the junction.*/
        //TODO: check if traffic priority related to location in allowedVehicles arraylist

    }

}

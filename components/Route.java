package components;

import utilities.Point;

import java.util.ArrayList;
import java.util.Random;


/**
 * *Class implement some route with junction and roads based on map features.
 *  @version 1.0 22.04.2020
 *  @author Yehonatan Hen-207630112
 * @author Rotem Librati-307903732
 *
 * @see Junction
 * @see Route
 * @see Map
 * @see game.Driving
 **/
public class Route {
    private ArrayList<Junction> junctions; //list of junctions on the route by the order of movement.
    private ArrayList<Road> roads;// list of roads on the route by the order of movement.
    private double delay; // time that will take vehicle to make this route.
    private VehicleType vehicleType;


    /**
     * constructor
     *
     * @param juncs
     * @param roads
     * @param vehType
     */
    public Route(ArrayList<Junction> juncs, ArrayList<Road> roads,final VehicleType vehType) {
        this.junctions = new ArrayList<>();
        this.junctions.addAll(juncs);
        this.roads = new ArrayList<>();
        this.vehicleType = new VehicleType(vehType.getTypeName(),vehType.getSpeed());
        Random r=new Random();
        this.delay = r.nextInt(11)+1;
    }


    /*not implemented in this task
    public Route(Junction start, Junction end, String vehType){}*/

    //getters
    public ArrayList<Junction> getJunctions() { return junctions;}
    public ArrayList<Road> getRoads() { return roads;}
    public double getDelay() { return delay; }
    public VehicleType getVehicleType() { return vehicleType; }

    //setters
    public void setJunctions(ArrayList<Junction> junctions) { this.junctions.addAll(junctions); }
    public void setRoads(ArrayList<Road> roads) { this.roads = roads; }
    public void setDelay(final double delay) { this.delay = delay; }
    public void setVehicleType(final VehicleType vehicleType) { this.vehicleType = vehicleType; }

    /**
     * get start of the route
     * @return start of the Route
     */
    public Junction getStart() { return junctions.get(0);}


    /**
     * get end of the route
     * @return end of the Route
     */
    public Junction getEnd() { return junctions.get(junctions.size()-1);}

    /**set length to be a sum of delay values of all the junctions
     *on the route and the time that will take this type of vehicle to pass all
     *the roads. Time is calculated by dividing the distance by min(average
     *speed, maxSpeed). The delay time on junctions is calculated according
     *to worse case: if there is a traffic lights on the junction, we use it’s
     *delay value multiplied by (number of entering roads minus one). If
     *there is no traffic lights on the junction, the delay time is the priority
     *level of the road that leads us to this junction (the index of this road in
     *the list of roads).*/
    public double calcDelay() {

        double length=0;
        double maxSpeed=0;
        for(int i=0;i<junctions.size();i++) {
            if (junctions.get(i).getHasLights()) {
                length += (junctions.get(i).getDelay()) * (junctions.get(i).getEnteringRoads().size() - 1);
            } else {
                for (int j = 0; j < roads.size(); j++) {
                    if (roads.get(j).getToJunc().equals(junctions.get(i))) {
                        length += j;
                    }
                }
            }
        }
        for(int i=0;i<roads.size();i++){
            if(maxSpeed<roads.get(i).getMaxSpeed()) maxSpeed=roads.get(i).getMaxSpeed();
            }
        delay+=length/(Math.min(vehicleType.speed,maxSpeed));
        return delay;
    }

    /**
     * Function prints the route junction
     */
    public void printRoute()

    {
        for(int i=0; i<junctions.size(); i++)
            System.out.println(junctions.get(i));
    }
}

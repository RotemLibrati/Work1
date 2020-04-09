package components;

import java.util.ArrayList;

public class Route {
    private ArrayList<Junction> junctions; //list of junctions on the route by the order of movement.
    private ArrayList<Road> roads;// list of roads on the route by the order of movement.
    private double delay; // time that will take vehicle to make this route.
    private VehicleType vehicleType;

    public Route(ArrayList<Junction> juncs, ArrayList<Road> roads, VehicleType vehType) {
        this.junctions = new ArrayList<>();
        this.junctions.addAll(juncs);
        this.roads = new ArrayList<>();
        this.roads.addAll(roads);
        this.vehicleType = new VehicleType(vehType.getTypeName(),vehType.getSpeed());
        this.delay = 0;
        this.vehicleType = null;
    }

    /*not implemented in this task
    public Route(Junction start, Junction end, String vehType);
    {

    }*/

    //TODO : they dont write if we need getters and setters.. check and remove if we dont need.
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
    public Junction getStart() { return junctions.get(0);}
    public Junction getEnd() { return junctions.get(junctions.size()-1);}

    public double calcDelay() {
        /*set length to be a sum of delay values of all the junctions
        *on the route //and the time that will take this type of vehicle to pass all
        *the roads. Time is calculated by dividing the distance by min(average
        *speed, maxSpeed). The delay time on junctions is calculated according
        *to worse case: if there is a traffic lights on the junction, we use it’s
        *delay value multiplied by (number of entering roads minus one). If
        *there is no traffic lights on the junction, the delay time is the priority
        *level of the road that leads us to this junction (the index of this road in
        *the list of roads).*/
        double time = 0;
        int i = 0;
        while(i < roads.size()) {
            time += roads.get(i).getLength() / roads.get(i).getMaxSpeed();// the distance of the roads dividing max speed in roads.
            i++;
        }
        while (i < junctions.size()) {
            if (junctions.get(i).getHasLights()) {
                time += junctions.get(i).getDelay() * (roads.size() - 1); //check if has traffic light in junction and calc time according formula .
                i++;
            }
            //TODO: check how calc which road get priority and complete the else according to this.
//            else {
//
//            }
        }
        return time;
    }
}

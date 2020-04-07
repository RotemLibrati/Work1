package components;

import java.util.ArrayList;

public class Route {
    private ArrayList<Junction> junctions; //list of junctions on the
    // route by the order of movement.
    private ArrayList<Road> roads;// list of roads on the route by the
    //order of movement.
    private double delay; // time that will take vehicle to make this route.
    private String vehicleType;

    public Route(ArrayList<Junction> juncs, ArrayList<Road> roads, String vehType) {
        this.junctions = new ArrayList<>();
        this.junctions.addAll(juncs);
        this.roads = new ArrayList<>();
        this.roads.addAll(roads);
        this.vehicleType = vehType;
        this.delay = 0;
        this.vehicleType = null;
    }
    //not implemented in this task
//    public Route(Junction start, Junction end, String vehType);
//    {
//
//    }
    //TODO : they dont write if we need getters and setters.. check and remove if we dont need.
    //getters
    public ArrayList<Junction> getJunctions() { return junctions;}
    public ArrayList<Road> getRoads() { return roads;}
    public double getDelay() { return delay; }
    public String getVehicleType() { return vehicleType; }

    //setters
    public void setJunctions(ArrayList<Junction> junctions) { this.junctions.addAll(junctions); }
    public void setRoads(ArrayList<Road> roads) { this.roads = roads; }
    public void setDelay(final double delay) { this.delay = delay; }
    public void setVehicleType(final String vehicleType) { this.vehicleType = vehicleType; }

    //public Junction getStart() { return }
    public double calcDelay() {
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

/*Yehonatan Hen-207630112
 * Rotem Librati-307903732
 */
package components;

import utilities.Point;

import java.util.ArrayList;
import java.util.Random;

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
        Random r=new Random();
        this.delay = r.nextInt(11)+1;
    }
    public Route(Junction junc, VehicleType vehicle)  // this constructor for TestRoute - only for checking !!!!!
    {
        this.junctions = new ArrayList<>();
        this.junctions.add(junc);
        this.roads = new ArrayList<>();
        this.vehicleType = new VehicleType(vehicle.getTypeName(),vehicle.getSpeed());
        this.delay = 0;
        this.vehicleType = vehicle;
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

    //get Start&End
    public Junction getStart() { return junctions.get(0);}
    public Junction getEnd() { return junctions.get(junctions.size()-1);}

    public double calcDelay() {
        /*set length to be a sum of delay values of all the junctions
        *on the route and the time that will take this type of vehicle to pass all
        *the roads. Time is calculated by dividing the distance by min(average
        *speed, maxSpeed). The delay time on junctions is calculated according
        *to worse case: if there is a traffic lights on the junction, we use it’s
        *delay value multiplied by (number of entering roads minus one). If
        *there is no traffic lights on the junction, the delay time is the priority
        *level of the road that leads us to this junction (the index of this road in
        *the list of roads).*/
        double length=0;
        double maxSpeed=0;
        for(int i=0;i<junctions.size();i++) {
            if (junctions.get(i).getHasLights()) {
                length += (junctions.get(i).getDelay()) * (junctions.get(i).getEnteringRoads().size() - 1);
            } else {
                for (int j = 0; j < roads.size(); j++) {
                    //if (maxSpeed < roads.get(j).getMaxSpeed()) maxSpeed = roads.get(j).getMaxSpeed();
                    if (roads.get(j).getToJunc() == junctions.get(i)) {
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

    public void printRoute()
    {
        for(int i=0; i<junctions.size(); i++)
            System.out.println(junctions.get(i));
    }
}

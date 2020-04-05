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
        location=new Point();

    }
}

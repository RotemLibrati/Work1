
package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utilities.Point;

/**
 * Implementation of Junction with entering/exiting roads and other features.
 *  @version 1.0 22.04.2020
 *  @author Yehonatan Hen-207630112
 * @author Rotem Librati-307903732
 * @see Route
 * @see Road
 * @see Vehicle
 * @see VehicleType
 **/
public class Map {
    private ArrayList<Junction> junctions;
    private ArrayList<Road> roads;

    /**
     * new constructor that receive number of junctions and connect between them with roads
     * @param number
     */
    public  Map(final int number)/***/
            //NOTE: This contructor is'nt part of the demanded constructors, However, it is a consequence of Test&Driving class demands
    {
        roads = new ArrayList<>();
        junctions = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            addJunction(new Junction(Integer.toString(i), new Point(Point.getRandomDoubleBetweenRange(1, 1000000), Point.getRandomDoubleBetweenRange(1, 800))));
        }
        for (int i = 0; i < number; i++) {
            Random rand = new Random();
            for (int j = 0; j < number; j++) {
                if (i != j) {
                    int randJunc = rand.nextInt(number);
                    Road tempRoad=new Road(junctions.get(i), junctions.get(j));
                    System.out.println(tempRoad + " has been created");
                    //Add road only if he is enabled (appears in the map)
                    if(tempRoad.getIsEnabled()) {
                        addRoad(tempRoad);
                    }
                    if (randJunc==j && roads.size()>=1) {
                        junctions.get(randJunc).setLightsOn();
                        junctions.get(randJunc).changeLights();
                        System.out.println(roads.get(roads.size()-1).toString() + ": green light");
                    }
                }
            }
        }
    }

    /**
     * create a map with 20 random junctions and connect
     * all of them one to another with roads.
     */
    public Map() {
        roads = new ArrayList<>();
        junctions = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            junctions.add(new Junction(Integer.toString(i), new Point(Point.getRandomDoubleBetweenRange(1, 1000000), Point.getRandomDoubleBetweenRange(1, 800))));
        }
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (i != j) {
                    roads.add(new Road(junctions.get(i), junctions.get(j)));
                }
            }
        }
    }

    /**
     * Creates a random map with given quantity of junctions and roads.
     *
     * @param junctions
     * @param roads
     */
    public Map( int junctions, int roads){
        this.roads=new ArrayList<>();
        this.junctions=new ArrayList<>();
        for (int i=0;i<junctions;i++){
            this.junctions.add(new Junction(Integer.toString(i),new Point(Point.getRandomDoubleBetweenRange(1,1000000),Point.getRandomDoubleBetweenRange(1,800))));
        }
        for(int i=0;i<junctions;i++){
            for(int j=0;j<roads;j++){
                if (i!=j) {
                    this.roads.add(new Road(this.junctions.get(i), this.junctions.get(j)));
                }
            }
        }
    }

    /**
     * Creates a map with given junctions and connects all of them with roads.
     *
     * @param juncs
     */
    public Map (ArrayList<Junction> juncs) {
        roads = new ArrayList<>();
        junctions = new ArrayList<>();
        junctions.addAll(juncs);
        for (int i = 0; i < junctions.size(); i++) {
            for (int j = 0; j < junctions.size(); j++) {
                if (i != j) {
                    roads.add(new Road(junctions.get(i), junctions.get(j)));
                }
            }
        }
    }

    /**
     * Creates a map with given junctions and roads.
     *
     * @param juncs
     * @param roads
     */
    public Map (ArrayList<Junction>juncs, ArrayList<Road>roads) {
    /***/
        this.roads=new ArrayList<>();
        junctions=new ArrayList<>();
        junctions.addAll(juncs);
        this.roads.addAll(roads);
    }

    /**
     * adding new road to the map
     *
     * @param r
     */
    public void addRoad(final Road r){
        for (Road road : roads) {
            if (road.equals(r)) return;
        }
        roads.add(r);
    }

    /**
     * remove exist road from the map
     *
     * @param r
     */
    public void removeRoad(final Road r){
        for (Road road : roads) {
            if (road.equals(r)) return;
        }
        roads.remove(r);
    }

    /**
     * adding new junction to the map
     *
     * @param junc
     */
    public void addJunction(final Junction junc){
        for (Junction junction: junctions) {
            if (junction.equals(junc)) return;
        }
        junctions.add(junc);
        System.out.println(junc.toString()+" has been added to the map.");
    }

    /**
     * remove exist junction from the map
     *
     * @param junc
     */
    public void removeJunction(final Junction junc){
        boolean flag=false;
        for(Junction junction : junctions){
            if(junction.equals(junc)) flag=true;
        }
        if(flag) {
            junctions.remove(junc);
            System.out.println(junc.toString()+" has been removed from the map.");
        }
    }

    public ArrayList<Junction> getJunctions() {
        return junctions;
    }
    public ArrayList<Road> getRoads() {
        return roads;
    }

}


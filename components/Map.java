package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utilities.Point;

public class Map {
    private ArrayList<Junction> junctions;
    private ArrayList<Road> roads;


    public  Map(int number)// new constructor that receive number of junctions and connect between them with roads
            //NOTE: This contructor is'nt part of the demanded constructors, However, it is a consequence of Test&Driving class demands
    {
        roads=new ArrayList<>();
        junctions=new ArrayList<>();
        for (int i=0;i<number;i++) {
            junctions.add(new Junction(Integer.toString(i), new Point(Point.getRandomDoubleBetweenRange(1, 1000000), Point.getRandomDoubleBetweenRange(1, 800))));
            System.out.println(junctions.get(i).getLocation().toString()+" has been created");
            System.out.println(junctions.get(i).toString()+" has been created");
        }
        for(int i=0;i<number;i++) {
            for (int j = 0; j < number; j++) {
                if (i != j) {
                    roads.add(new Road(junctions.get(i), junctions.get(j)));
                    roads.get(i).getFromJunc().setLightsOn();
                    System.out.println("Road from " + i + " to " + j);
                }
            }
        }
    }
    public Map() {
        // create a map with 20 random junctions and connect
        // all of them one to another with roads.
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

    public Map(int junctions, int roads){
    //Creates a random map with given quantity of junctions and roads.
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

    public Map (ArrayList<Junction> juncs) {
        //Creates a map with given junctions and connects all of them with roads.
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

    public Map (ArrayList<Junction>juncs, ArrayList<Road>roads) {
    //Creates a map with given junctions and roads.
        this.roads=new ArrayList<>();
        junctions=new ArrayList<>();
        junctions.addAll(juncs);
        this.roads.addAll(roads);
    }

    public void addRoad(Road r){
        for (Road road : roads) {
            if (road.equals(r)) return;
        }
        roads.add(r);
    }

    public void removeRoad(Road r){
        for (Road road : roads) {
            if (road.equals(r)) return;
        }
        roads.remove(r);
    }

    public void addJunction(Junction junc){
        for (Junction junction: junctions) {
            if (junction.equals(junc)) return;
        }
        junctions.add(junc);
    }
    public void removeJunction(Junction junc){
        for(Junction junction : junctions){
            if(junction.equals(junc)) return;
        }
        junctions.remove(junc);
    }

    public ArrayList<Junction> getJunctions() {
        return junctions;
    }
    public ArrayList<Road> getRoads() {
        return roads;
    }
}
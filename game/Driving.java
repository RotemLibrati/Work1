/*Yehonatan Hen-207630112
 * Rotem Librati-307903732
 */
package game;
import  components.*;
import utilities.Point;

import java.util.ArrayList;
import java.util.Random;


public class Driving
{
    private int numOfJuncs;
    private int numOfVehicles;
    private Map currentMap;
    private ArrayList<Vehicle> currentVehicles;
    private double drivingTime; // time passed from the beginning of driving session
    private int maxTime; // total round time

    public Driving(int juncs,int vehicles,int maxTime){
        numOfJuncs=juncs;
        numOfVehicles=vehicles;
        this.maxTime=maxTime;
        //currentVehicles=new ArrayList<>();
        currentMap=new Map(numOfJuncs);
        addVehicles();
        drivingTime=0;
    }

    //getters
    public int getNumOfJuncs(){return numOfJuncs;}
    public int getNumOfVehicles(){return numOfVehicles;}
    public Map getCurrentMap(){return currentMap;}
    public ArrayList<Vehicle> getVehicles(){return currentVehicles;}
    public double getDrivingTime(){return drivingTime;}
    public int getMaxTime(){return maxTime;}

    //setters
    public void setNumOfJuncs(int juncs){numOfJuncs=juncs;}
    public void setNumOfVehicles(int vehicles){numOfVehicles=vehicles;}
    public void setCurrentMap(Map map){currentMap=map;}
    public void setCurrentVehicles(ArrayList<Vehicle> arr){
        currentVehicles.clear();
        currentVehicles.addAll(arr);
    }
    public void setDrivingTime(double dTime){drivingTime=dTime;}
    public void setMaxTime(int max){maxTime=max;}

    public void addMap(){
        //creates a map with random (10-25) junctions quantity
        Random rand=new Random();
        numOfJuncs=rand.nextInt(26)+10;
        currentMap=new Map(numOfJuncs);
    }



    public void addVehicles() {
        //creates random number (2-8) of vehicles of different types.
        VehicleType[] arr = {new VehicleType("bus", 60), new VehicleType("motorcycle", 120), new VehicleType("car", 90),
                new VehicleType("truck", 80), new VehicleType("semitrailer", 80), new VehicleType("bicycle", 40),
                new VehicleType("tram", 50), new VehicleType("ambulance", 100)};
        Random r = new Random();
        Junction start;
        currentVehicles = new ArrayList<>();
        for (int i = 0; i < numOfVehicles; i++) {
            VehicleType t = arr[r.nextInt(8)];
            start = currentMap.getJunctions().get(r.nextInt(currentMap.getJunctions().size()));
            currentVehicles.add(new Vehicle(i, t, start));
            //make randomal route
            for (int j = 0; j < numOfJuncs; j++) {
                int indexOfNextJunc = r.nextInt(numOfJuncs);
                if (!currentVehicles.get(i).getCurrentRoute().getJunctions().contains(currentMap.getJunctions().get(indexOfNextJunc))) {
                    currentVehicles.get(i).getCurrentRoute().getJunctions().add(currentVehicles.get(i).getCurrentRoute().getJunctions().size(), currentMap.getJunctions().get(indexOfNextJunc));
                    currentVehicles.get(i).getCurrentRoute().getRoads().add(new Road(start, currentMap.getJunctions().get(indexOfNextJunc)));
                    start = currentMap.getJunctions().get(indexOfNextJunc);
                }
            }
        }

    }

    public void startDrive(int maxTime){
        for(int i=0;i<maxTime;i++){
            System.out.println("TURN "+(i+1));
            for(int j=0;j<numOfVehicles;j++){
                currentVehicles.get(j).move();
            }
            for(int j=0;j<currentMap.getRoads().size();j++){
                currentMap.getRoads().get(j).getToJunc().changeLights();
               currentMap.getRoads().get(j).getFromJunc().changeLights();
                if(currentMap.getRoads().get(j).getFromJunc().getHasLights())
                    System.out.println(currentMap.getRoads().get(j).toString()+": green light");
           }


        }
        System.out.println("STATUS");
        for(int i=0;i<currentVehicles.size();i++){
            currentVehicles.get(i).status();
        }
    }
}

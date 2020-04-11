package game;
import  components.*;

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
        currentVehicles=new ArrayList<>();
        drivingTime=0;
    }

    //getters
    public int getNumOfJuncs(){return numOfJuncs;}
    public int getNumOfVehicles(){return numOfVehicles;}
    public Map getCurrentMap(){return currentMap;}
    public ArrayList<Vehicle> getCurrentVehicles(){return currentVehicles;}
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
        Random rand=new Random();
        numOfJuncs=rand.nextInt(26)+10;
        currentMap=new Map(numOfJuncs);
    }

    public void addVehicels(){
        R
    }
}

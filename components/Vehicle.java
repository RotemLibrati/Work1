package components;

public class Vehicle {
    private int id;
    private VehicleType type;
    private int speed;  //average speed for this type of vehicle.
    private Route currentRoute;
    private Junction lastJunction; //current junction or last junction where the vehicle visited
    private Road lastRoad;
    private boolean movesNow; //True if the vehicle is on the road between the junctions.
    private double spentTime;  //time passed from the beginning of movement on the route.

    public Vehicle(int id,VehicleType type, Junction lastJunction){
        this.id=id;
        this.type=type;
        this.lastJunction=lastJunction;
    }

    //getters
    public int getID(){return id;}
    public VehicleType getType(){return type;}
    public int getSpeed(){return speed;}
    public Route getCurrentRoute(){return currentRoute;}
    public Junction getLastJunction(){return lastJunction;}
    public Road getLastRoad(){return lastRoad;}
    public boolean getMovesNow(){return movesNow;}
    public double getSpentTime(){return spentTime;}

    //setters
    public void setID(final int id){this.id=id;}
    public void setType(final VehicleType type){this.type=type;}
    public void setSpeed(final int speed){this.speed=speed;}
    public void setCurrentRoute(final Route currentRoute){this.currentRoute=currentRoute;}
    public void setLastJunction(final Junction lastJunction){this.lastJunction=lastJunction;}
    public void setLastRoad(final Road lastRoad){this.lastRoad=lastRoad;}
    public void setMovesNow(final boolean movesNow){this.movesNow=movesNow;}
    public void setSpentTime(final double spentTime){this.spentTime=spentTime;}

    public void move(){
    /* wait for the current point delay time and move to the next
    point of the route.*/
    int i=0;
    while(lastJunction.equals(currentRoute.getJunctions().get(i))){
            i++;
        }
    i++;
    lastJunction=currentRoute.getJunctions().get(i);
    }

    public void status() {
    /*prints the details about the vehicle including current
    position, time spent on the route and the first and last junctions on the route*/
        System.out.println("Vehicle details:\nID:" + id + "\nType:" + type);
        System.out.println("Time spent:" + spentTime);
        if (currentRoute.getJunctions().size() > 0) {
            System.out.println("First junction on the route:" + currentRoute.getJunctions().get(0));
            if (currentRoute.getJunctions().size()>1) {
                System.out.println("Last junction on the route:" +
                        currentRoute.getJunctions().get(currentRoute.getJunctions().size() - 1));
            }
            else System.out.println("There are only one junction on the route");
        }
        else System.out.println("There are no junctions on the route");
    }

    public void checkIn(){
     /*if arrived to a junction, update the junction waiting list
      and calculate the delay time before the next move.*/
     lastJunction.getVehicles().add(lastRoad);
     lastJunction.setDelay((int)currentRoute.calcDelay());
    }
}
package ElavatorLLD;

import java.util.HashSet;
import java.util.Scanner;

public class Elevator {



    public enum DIRECTION{
        IDLE,UP,DOWN
    }
    private DIRECTION direction = DIRECTION.IDLE;
    private int currentFloor=0;
    private final int maxFloors;
    private final int minFloors;
    private int droppingFloor;
    private boolean isWorking = true;


    ElevatorListener elevatorListener;

    public Elevator(int maxFloors, int minFloors) {
        this.maxFloors = maxFloors;
        this.minFloors = minFloors;
    }

    public void floorToGo(){

        System.out.println("input to floor to go");
        Scanner sc = new Scanner(System.in);
        int floor = sc.nextInt();
        setDroppingFloor(floor);
        setDirection(floor);

    }
    public void setDroppingFloor(int floor){
            this.droppingFloor = floor;
    }

    public int getDroppingFloor(){
        return droppingFloor;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public void setIsWorking(boolean isWorking){
        this.isWorking = isWorking;
    }

    public boolean getIsWorking(){
        return isWorking;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(int floor) {

        if(floor> currentFloor)
            direction = DIRECTION.UP;
        else if (floor < currentFloor)
            direction = DIRECTION.DOWN;
        else
            direction = DIRECTION.IDLE;
    }

    public void moveNext() {

        if(direction == DIRECTION.IDLE)
            elevatorListener.onIdle(this);
        else{

            if(currentFloor==droppingFloor){
                direction = DIRECTION.IDLE;
                elevatorListener.onIdle(this);
            }
            else if(droppingFloor > currentFloor){
                currentFloor++;
            }
            else{
                currentFloor--;
            }
        }

    }

    public ElevatorListener getElevatorListener() {
        return elevatorListener;
    }

    public void setElevatorListener(ElevatorListener elevatorListener) {
        this.elevatorListener = elevatorListener;
    }
}

package ElavatorLLD;

import java.util.*;

public class ElevatorController implements IElevatorController,ElevatorListener{

    private ArrayList<Elevator> elevators;
    private HashMap<Elevator,Queue<Integer>> elevatorTaskQueue;

    private int minFloors;
    private int maxFloors;
    private int numElevators;


    public ElevatorController(int minFloors, int maxFloors,int numElevators) {
        initElevators(minFloors,maxFloors,numElevators);
        this.numElevators = numElevators;
        this.minFloors = minFloors;
        this.maxFloors = maxFloors;

    }

    private void initElevators(int minFloors, int maxFloors, int numElevators) {
        if(numElevators<0) throw new IllegalArgumentException();

        elevatorTaskQueue = new HashMap<>();

        for(int i=0;i<numElevators;i++){
            Elevator elevator = new Elevator(maxFloors,minFloors);
            elevator.setElevatorListener(this);
            elevators.add(elevator);
            elevatorTaskQueue.put(elevator,new LinkedList<>());
        }
    }

    private int closestElevator(int pickupFloor,int curFloor){
        return Math.abs(pickupFloor-curFloor);
    }

    @Override
    public void status() {
        int i=0;
        for (Elevator e : elevators)
            System.out.println("EId: "+ i++ + " Current Floor: "+e.getCurrentFloor()+" Direction: "+e.getDirection());
    }

    @Override
    public Elevator getElevator(int elevatorId) {
        return elevators.get(elevatorId);
    }

    @Override
    public void update(int elevatorId, int floor) {

    }

    @Override
    public void pickup(int floor, boolean direction) {

        Elevator selectedElevator = null;
        int minDis=maxFloors*10;
        for(Elevator e : elevators){
            int totDis = 0;
            if(e.getDirection()== Elevator.DIRECTION.IDLE){
                totDis = closestElevator(floor,e.getCurrentFloor());
            }
            else {
                totDis = closestElevator(e.getDroppingFloor(),e.getCurrentFloor());
                totDis+= closestElevator(floor,e.getDroppingFloor());
            }

            if(totDis<minDis){
                minDis =totDis;
                selectedElevator =e;
            }

        }

        elevatorTaskQueue.get(selectedElevator).add(floor);

    }

    public void step() {
            for(Elevator e : elevators){
                e.moveNext();
            }
    }

    @Override
    public void onIdle(Elevator elevator) {
            
        Optional<Integer> frontVal = Optional.ofNullable(elevatorTaskQueue.get(elevator).peek());

        if(frontVal.isPresent() && (elevator.getCurrentFloor()==frontVal.get())){

            elevatorTaskQueue.get(elevator).poll();
            elevator.floorToGo();
        }
        else if(frontVal.isPresent()){

            elevator.setDroppingFloor(frontVal.get());
            elevator.setDirection(frontVal.get());

        }
    }
}

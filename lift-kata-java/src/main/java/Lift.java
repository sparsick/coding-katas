public class Lift {


    private LiftDirection currentLiftDirection = LiftDirection.UP;
    private int currentFloor = 0;
    private FloorRequestQueue floorRequestQueue;

    public Lift(FloorRequestQueue floorRequestQueue) {
        this.floorRequestQueue = floorRequestQueue;
    }

    public LiftResponse call(FloorRequest floorRequest) {
        floorRequestQueue.add(floorRequest);
        return new LiftResponse(currentFloor, currentLiftDirection);
    }

    void initStatus(int currentFloor, LiftDirection liftDirection) {
        this.currentFloor = currentFloor;
        this.currentLiftDirection = liftDirection;
    }
}

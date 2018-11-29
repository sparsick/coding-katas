public class Lift {


    private LiftDirection currentLiftDirection = LiftDirection.UP;
    private int currentFloor = 0;

    public LiftResponse call(FloorRequest floorRequest) {
        return new LiftResponse(currentFloor, currentLiftDirection);
    }

    void initStatus(int currentFloor, LiftDirection liftDirection) {
        this.currentFloor = currentFloor;
        this.currentLiftDirection = liftDirection;
    }
}

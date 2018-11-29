public class Lift {


    private final LiftDirection up = LiftDirection.UP;
    private int currentFloor = 0;

    public LiftResponse call(FloorRequest floorRequest) {
        return new LiftResponse(currentFloor, up);
    }
}

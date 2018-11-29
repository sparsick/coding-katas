public class FloorRequest {
    private final int floorNumber;
    private final LiftDirection liftDirection;

    public FloorRequest(int floorNumber, LiftDirection liftDirection) {
        this.floorNumber = floorNumber;
        this.liftDirection = liftDirection;
    }

    public int floorNumber() {
        return floorNumber;
    }
}

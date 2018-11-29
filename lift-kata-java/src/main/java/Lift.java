public class Lift {


    private LiftDirection currentLiftDirection;
    private int currentFloor;
    private FloorRequestQueue floorRequestQueue;

    public Lift(FloorRequestQueue floorRequestQueue) {
        this(new DefaultConfiguration(), floorRequestQueue);
    }

    public Lift(LiftConfiguration liftConfiguration, FloorRequestQueue floorRequestQueue) {
        this.floorRequestQueue = floorRequestQueue;
        this.currentFloor = liftConfiguration.startInFloor();
        this.currentLiftDirection = liftConfiguration.startLiftDirection();
    }

    public LiftResponse call(FloorRequest floorRequest) {
        floorRequestQueue.add(floorRequest);
        return new LiftResponse(currentFloor, currentLiftDirection);
    }

    void initStatus(int currentFloor, LiftDirection liftDirection) {
        this.currentFloor = currentFloor;
        this.currentLiftDirection = liftDirection;
    }

    private static class DefaultConfiguration implements LiftConfiguration {
        @Override
        public int startInFloor() {
            return 0;
        }

        @Override
        public LiftDirection startLiftDirection() {
            return LiftDirection.UP;
        }
    }
}

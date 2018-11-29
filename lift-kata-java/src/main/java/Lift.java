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

    public LiftStatus call(FloorRequest floorRequest) {
        floorRequestQueue.add(floorRequest);
        return new LiftStatus(currentFloor, currentLiftDirection);
    }

    public LiftStatus nextFloor() {
        if(floorRequestQueue.hasRequests()){
            FloorRequest floorRequest = floorRequestQueue.poll();
            currentLiftDirection = findNewLiftDirection(floorRequest);
            currentFloor = floorRequest.floorNumber();
        }
        return new LiftStatus(currentFloor, currentLiftDirection);
    }

    private LiftDirection findNewLiftDirection(FloorRequest floorRequest) {
        return currentFloor - floorRequest.floorNumber() > 0 ? LiftDirection.DOWN : LiftDirection.UP;
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

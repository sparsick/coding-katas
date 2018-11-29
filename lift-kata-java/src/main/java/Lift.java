public class Lift {


    private final Door door;
    private int currentFloor;
    private FloorRequestQueue floorRequestQueue;

    public Lift(FloorRequestQueue floorRequestQueue, Door door) {
        this(new DefaultConfiguration(), floorRequestQueue, door);
    }

    public Lift(LiftConfiguration liftConfiguration, FloorRequestQueue floorRequestQueue, Door door) {
        this.floorRequestQueue = floorRequestQueue;
        this.currentFloor = liftConfiguration.startInFloor();
        this.door = door;
    }

    public LiftStatus call(FloorRequest floorRequest) {
        floorRequestQueue.add(floorRequest);
        return new LiftStatus(currentFloor);
    }

    public LiftStatus nextFloor() {
        door.isClosed();
        if(floorRequestQueue.hasRequests()){
            FloorRequest floorRequest = floorRequestQueue.poll();
            currentFloor = floorRequest.floorNumber();
        }
        return new LiftStatus(currentFloor);
    }

    public void selectFloor(FloorRequest floorRequest) {
        floorRequestQueue.add(floorRequest);
    }

    private static class DefaultConfiguration implements LiftConfiguration {
        @Override
        public int startInFloor() {
            return 0;
        }
    }
}

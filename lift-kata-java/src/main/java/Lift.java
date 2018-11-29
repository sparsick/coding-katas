public class Lift {


    private int currentFloor;

    private final Door door;
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
        if(floorRequestQueue.hasRequests()){
            FloorRequest floorRequest = floorRequestQueue.poll();
            currentFloor = floorRequest.floorNumber();

            if(door.isClosed()){
                door.close();
            }
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

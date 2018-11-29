public class Lift {


    private int currentFloor;
    private FloorRequestQueue floorRequestQueue;

    public Lift(FloorRequestQueue floorRequestQueue) {
        this(new DefaultConfiguration(), floorRequestQueue);
    }

    public Lift(LiftConfiguration liftConfiguration, FloorRequestQueue floorRequestQueue) {
        this.floorRequestQueue = floorRequestQueue;
        this.currentFloor = liftConfiguration.startInFloor();
    }

    public LiftStatus call(FloorRequest floorRequest) {
        floorRequestQueue.add(floorRequest);
        return new LiftStatus(currentFloor);
    }

    public LiftStatus nextFloor() {
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

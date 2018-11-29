import java.util.LinkedList;
import java.util.Queue;

public class FloorRequestQueue {

    private Queue<FloorRequest> queue = new LinkedList<>();

    public void add(FloorRequest floorRequest) {
        queue.add(floorRequest);
    }

    public boolean hasRequests() {
        return !queue.isEmpty();
    }

    public FloorRequest poll() {
        return queue.poll();
    }
}

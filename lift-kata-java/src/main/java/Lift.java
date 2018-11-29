import com.sun.javafx.scene.traversal.Direction;

public class Lift {


    public LiftResponse call(FloorRequest floorRequest) {
        return new LiftResponse(0, LiftDirection.UP);
    }
}

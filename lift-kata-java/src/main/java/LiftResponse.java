import com.sun.javafx.scene.traversal.Direction;

public class LiftResponse {
    private final int currentFloor;
    private final LiftDirection liftDirection;

    public LiftResponse(int currentFloor, LiftDirection liftDirection) {
        this.currentFloor = currentFloor;
        this.liftDirection = liftDirection;
    }
}

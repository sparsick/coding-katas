import com.sun.javafx.scene.traversal.Direction;
import java.util.Objects;

public class LiftStatus {
    private final int currentFloor;
    private final LiftDirection liftDirection;

    public LiftStatus(int currentFloor, LiftDirection liftDirection) {
        this.currentFloor = currentFloor;
        this.liftDirection = liftDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LiftStatus that = (LiftStatus) o;
        return currentFloor == that.currentFloor &&
                liftDirection == that.liftDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentFloor, liftDirection);
    }
}

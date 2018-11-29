import com.sun.javafx.scene.traversal.Direction;
import java.util.Objects;

public class LiftStatus {
    private final int currentFloor;

    public LiftStatus(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LiftStatus that = (LiftStatus) o;
        return currentFloor == that.currentFloor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentFloor);
    }
}

import java.util.Objects;

public class FloorRequest {
    private final int floorNumber;

    public FloorRequest(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int floorNumber() {
        return floorNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        FloorRequest that = (FloorRequest) o;
        return floorNumber == that.floorNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorNumber);
    }
}

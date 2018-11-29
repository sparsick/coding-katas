import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LiftTest {

    @Mock
    private FloorRequestQueue floorRequestQueueMock;
    private Lift liftUnderTest;


    @BeforeEach
    void setUp() {
        liftUnderTest = new Lift(floorRequestQueueMock);
    }

    @Test
    void callLift_forFloor2_liftIsOnGroundFloor() {

        LiftResponse response = liftUnderTest.call(new FloorRequest(2, LiftDirection.UP));

        assertThat(response).hasFieldOrPropertyWithValue("currentFloor", 0)
                .hasFieldOrPropertyWithValue("liftDirection", LiftDirection.UP);
    }

    @Test
    void callLift_forFloor2_liftIsOnFirstFloor() {
        liftUnderTest.initStatus(1, LiftDirection.DOWN);

        LiftResponse response = liftUnderTest.call(new FloorRequest(2, LiftDirection.UP));

        assertThat(response).hasFieldOrPropertyWithValue("currentFloor", 1)
                .hasFieldOrPropertyWithValue("liftDirection", LiftDirection.DOWN);
    }

    @Test
    void callLift_forFloor2_floorRequestIsAddedToQueue() {
        FloorRequest expectedFloorRequest = new FloorRequest(2, LiftDirection.UP);

        LiftResponse response = liftUnderTest.call(expectedFloorRequest);

        verify(floorRequestQueueMock).add(expectedFloorRequest);
    }


}

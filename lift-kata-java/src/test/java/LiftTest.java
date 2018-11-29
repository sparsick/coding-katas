import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
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

        LiftStatus response = liftUnderTest.call(new FloorRequest(2));

        assertThat(response).hasFieldOrPropertyWithValue("currentFloor", 0);
    }

    @Test
    void callLift_forFloor2_liftIsOnFirstFloor() {
        liftUnderTest = new Lift(liftStartAtFirstFloor(), floorRequestQueueMock);

        LiftStatus response = liftUnderTest.call(new FloorRequest(2));

        assertThat(response).hasFieldOrPropertyWithValue("currentFloor", 1);
    }

    @Test
    void callLift_forFloor2_floorRequestIsAddedToQueue() {
        FloorRequest expectedFloorRequest = new FloorRequest(2);

        liftUnderTest.call(expectedFloorRequest);

        verify(floorRequestQueueMock).add(expectedFloorRequest);
    }

    @Test
    void nextFloor_floorRequestQueueIsEmpty(){
        when(floorRequestQueueMock.hasRequests()).thenReturn(false);

        LiftStatus nextFloor = liftUnderTest.nextFloor();

        assertThat(nextFloor).isEqualTo(new LiftStatus(0));
    }

    @Test
    void nextFloor_floorRequestQueueNotEmpty_currentDirectionIsUp(){
        when(floorRequestQueueMock.hasRequests()).thenReturn(true);
        when(floorRequestQueueMock.poll()).thenReturn(new FloorRequest(2));

        LiftStatus nextFloor = liftUnderTest.nextFloor();

        assertThat(nextFloor).isEqualTo(new LiftStatus(2));
    }

    @Test
    void nextFloor_floorRequestQueueNotEmpty_currentDirectionIsDown(){
        liftUnderTest = new Lift(liftStartAtFirstFloor(), floorRequestQueueMock);

        when(floorRequestQueueMock.hasRequests()).thenReturn(true);
        when(floorRequestQueueMock.poll()).thenReturn(new FloorRequest(0));

        LiftStatus nextFloor = liftUnderTest.nextFloor();

        assertThat(nextFloor).isEqualTo(new LiftStatus(0));
    }

    @Test
    void selectFloor_addNewRequestInQueue(){
        FloorRequest expectedFloorRequest = new FloorRequest(2);
        liftUnderTest.selectFloor(expectedFloorRequest);

        verify(floorRequestQueueMock).add(expectedFloorRequest);
    }


    private LiftConfiguration liftStartAtFirstFloor() {
        return new LiftConfiguration() {
            @Override
            public int startInFloor(){
                return 1;
            }
        };
    }


}

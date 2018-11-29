import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LiftTest {


    @Test
    void callLift_forFloor2_liftIsOnGroundFloor(){
        Lift liftUnderTest = new Lift();

        LiftResponse response = liftUnderTest.call(new FloorRequest(2, LiftDirection.UP));

        assertThat(response).hasFieldOrPropertyWithValue("currentFloor", 0)
                            .hasFieldOrPropertyWithValue("liftDirection", LiftDirection.UP);
    }

    @Test
    void callLift_forFloor2_liftIsOnFirstFloor(){
        Lift liftUnderTest = new Lift();
        liftUnderTest.initStatus(1, LiftDirection.DOWN);

        LiftResponse response = liftUnderTest.call(new FloorRequest(2, LiftDirection.UP));

        assertThat(response).hasFieldOrPropertyWithValue("currentFloor", 1)
                .hasFieldOrPropertyWithValue("liftDirection", LiftDirection.DOWN);
    }
}

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FloorRequestQueueTest {

    private FloorRequestQueue queueUnderTest = new FloorRequestQueue();

    @Test
    void hasRequests_queueIsEmpty() {
        boolean result = queueUnderTest.hasRequests();

        assertThat(result).isFalse();
    }

    @Test
    void add_addRequestToQueue() {
        queueUnderTest.add(new FloorRequest(2));

        assertThat(queueUnderTest.hasRequests()).isTrue();
    }


    @Test
    void poll() {
        FloorRequest expectedFloorRequest = new FloorRequest(2);
        queueUnderTest.add(expectedFloorRequest);

        FloorRequest floorRequest = queueUnderTest.poll();

        assertThat(floorRequest).isEqualTo(expectedFloorRequest);
        assertThat(queueUnderTest.hasRequests()).isFalse();
    }
}
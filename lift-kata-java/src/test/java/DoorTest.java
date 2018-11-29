import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoorTest {

    private Door doorUnderTest = new Door();

    @Test
    void doorIsClosed_openTheDoor(){
        doorUnderTest.open();

        assertFalse(doorUnderTest.isClosed());
    }

    @Test
    void doorIsOpen_closeTheDoor(){
        doorUnderTest.close();

        assertTrue(doorUnderTest.isClosed());
    }

}
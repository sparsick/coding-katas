package com.github.sparsick.coding.kata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *
 * 
 */
public class RoverTest {
    
    
    @Test
    public void initialRover_northDirection(){
       Rover roverUnderTest = new Rover(new Position(0,0), Direction.NORTH);
       
       Position currentPosition = roverUnderTest.currentPosition();
       Direction currentDirection = roverUnderTest.currentDirection();
       
       assertThat(currentPosition.x).isEqualTo(0);
       assertThat(currentPosition.y).isEqualTo(0);
       assertThat(currentDirection).isEqualTo(Direction.NORTH);
       
    }
    


}

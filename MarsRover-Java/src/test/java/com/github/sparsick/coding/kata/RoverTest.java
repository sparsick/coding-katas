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
    

     @Test
    public void initialRover_southDirection(){
       Rover roverUnderTest = new Rover(new Position(10,10), Direction.SOUTH);
       
       Position currentPosition = roverUnderTest.currentPosition();
       Direction currentDirection = roverUnderTest.currentDirection();
       
       assertThat(currentPosition.x).isEqualTo(10);
       assertThat(currentPosition.y).isEqualTo(10);
       assertThat(currentDirection).isEqualTo(Direction.SOUTH);
    }
    
        @Test
    public void initialRover_westDirection(){
       Rover roverUnderTest = new Rover(new Position(10,10), Direction.WEST);
       
       Position currentPosition = roverUnderTest.currentPosition();
       Direction currentDirection = roverUnderTest.currentDirection();
       
       assertThat(currentPosition.x).isEqualTo(10);
       assertThat(currentPosition.y).isEqualTo(10);
       assertThat(currentDirection).isEqualTo(Direction.WEST);
    }
}

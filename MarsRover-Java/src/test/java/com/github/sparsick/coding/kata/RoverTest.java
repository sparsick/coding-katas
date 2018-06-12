package com.github.sparsick.coding.kata;

import static com.github.sparsick.coding.kata.Direction.EAST;
import static com.github.sparsick.coding.kata.Direction.NORTH;
import static com.github.sparsick.coding.kata.Direction.SOUTH;
import static com.github.sparsick.coding.kata.Direction.WEST;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *
 *
 */
public class RoverTest {

    @Test
    public void initialRover_northDirection() {
        Rover roverUnderTest = new Rover(new Position(0, 0), Direction.NORTH);

        Position currentPosition = roverUnderTest.currentPosition();
        Direction currentDirection = roverUnderTest.currentDirection();

        assertThat(currentPosition).isEqualTo(new Position(0, 0));
        assertThat(currentDirection).isEqualTo(Direction.NORTH);

    }

    @Test
    public void initialRover_southDirection() {
        Rover roverUnderTest = new Rover(new Position(10, 10), Direction.SOUTH);

        Position currentPosition = roverUnderTest.currentPosition();
        Direction currentDirection = roverUnderTest.currentDirection();

        assertThat(currentPosition).isEqualTo(new Position(10, 10));
        assertThat(currentDirection).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void initialRover_westDirection() {
        Rover roverUnderTest = new Rover(new Position(10, 10), Direction.WEST);

        Position currentPosition = roverUnderTest.currentPosition();
        Direction currentDirection = roverUnderTest.currentDirection();

        assertThat(currentPosition).isEqualTo(new Position(10, 10));
        assertThat(currentDirection).isEqualTo(Direction.WEST);
    }

    @Test
    public void initialRover_eastDirection() {
        Rover roverUnderTest = new Rover(new Position(10, 10), Direction.EAST);

        Position currentPosition = roverUnderTest.currentPosition();
        Direction currentDirection = roverUnderTest.currentDirection();

        assertThat(currentPosition).isEqualTo(new Position(10, 10));
        assertThat(currentDirection).isEqualTo(Direction.EAST);
    }

    @Test
    public void commads_singleForwardMoveCommand() {
        Rover roverUnderTest = new Rover(new Position(10, 10), WEST);

        roverUnderTest.commands("f");

        Position currentPosition = roverUnderTest.currentPosition();
        assertThat(currentPosition).isEqualTo(new Position(9, 10));
    }

    @Test
    public void commads_singleBackwardMoveCommand() {
        Rover roverUnderTest = new Rover(new Position(10, 10), EAST);

        roverUnderTest.commands("b");

        Position currentPosition = roverUnderTest.currentPosition();
        assertThat(currentPosition).isEqualTo(new Position(9, 10));
    }

    @Test
    public void commads_singleLeftTurnCommand() {
        Rover roverUnderTest = new Rover(new Position(10, 10), EAST);

        roverUnderTest.commands("l");

        Direction currentDirection = roverUnderTest.currentDirection();
        assertThat(currentDirection).isEqualTo(NORTH);
    }

    @Test
    public void commads_singleRightTurnCommand() {
        Rover roverUnderTest = new Rover(new Position(10, 10), EAST);

        roverUnderTest.commands("r");

        Direction currentDirection = roverUnderTest.currentDirection();
        assertThat(currentDirection).isEqualTo(SOUTH);
    }

    @Test
    public void commands_commandChainOnlyMoving() {
        Rover roverUnderTest = new Rover(new Position(10, 10), WEST);

        roverUnderTest.commands("ff");

        Position currentPosition = roverUnderTest.currentPosition();
        assertThat(currentPosition).isEqualTo(new Position(8, 10));

    }

    @Test
    public void commands_commandChainTurningAndMoving() {
        Rover roverUnderTest = new Rover(new Position(10, 10), WEST);

        roverUnderTest.commands("fl");

        Position currentPosition = roverUnderTest.currentPosition();
        Direction currentDirection = roverUnderTest.currentDirection();
        assertThat(currentPosition).isEqualTo(new Position(9, 10));
        assertThat(currentDirection).isEqualTo(SOUTH);
    }
    
    @Test
    public void commands_overBoundaries(){
        Rover roverUnderTest = new Rover(new Position(10,10), EAST, new PlanetMap(new Boundary(10,10)));
        
        roverUnderTest.commands("f");
        
        Position currentPosition = roverUnderTest.currentPosition();
        
        assertThat(currentPosition).isEqualTo(new Position(0, 10));
        
    }
    
}

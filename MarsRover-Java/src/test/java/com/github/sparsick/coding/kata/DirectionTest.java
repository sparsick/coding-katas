/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sparsick.coding.kata;

import static com.github.sparsick.coding.kata.Direction.EAST;
import static com.github.sparsick.coding.kata.Direction.NORTH;
import static com.github.sparsick.coding.kata.Direction.SOUTH;
import static com.github.sparsick.coding.kata.Direction.WEST;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *
 * @author sparsick
 */
public class DirectionTest {

    @Test
    public void turnRight_startingDirectionNorth() {
        Direction directionUnderTest = NORTH;

        Direction newDirection = directionUnderTest.turnRight();

        assertThat(newDirection).isEqualTo(EAST);

    }

    @Test
    public void turnRight_startingDirectionWest() {
        Direction directionUnderTest = WEST;

        Direction newDirection = directionUnderTest.turnRight();

        assertThat(newDirection).isEqualTo(NORTH);
    }

    @Test
    public void turnRight_startingDirectionSouth() {
        Direction directionUnderTest = SOUTH;

        Direction newDirection = directionUnderTest.turnRight();

        assertThat(newDirection).isEqualTo(WEST);
    }

    @Test
    public void turnRight_startingDirectionEast() {
        Direction directionUnderTest = EAST;

        Direction newDirection = directionUnderTest.turnRight();

        assertThat(newDirection).isEqualTo(SOUTH);
    }

    @Test
    public void turnLeft_startingDirectionWest() {
        Direction directionUnderTest = WEST;

        Direction newDirection = directionUnderTest.turnLeft();

        assertThat(newDirection).isEqualTo(SOUTH);
    }

    @Test
    public void turnLeft_startingDirectionNorth() {
        Direction directionUnderTest = NORTH;

        Direction newDirection = directionUnderTest.turnLeft();

        assertThat(newDirection).isEqualTo(WEST);
    }

    @Test
    public void turnLeft_startingDirectionEast() {
        Direction directionUnderTest = EAST;

        Direction newDirection = directionUnderTest.turnLeft();

        assertThat(newDirection).isEqualTo(NORTH);
    }

    @Test
    public void turnLeft_startingDirectionSouth() {
        Direction directionUnderTest = SOUTH;

        Direction newDirection = directionUnderTest.turnLeft();

        assertThat(newDirection).isEqualTo(EAST);
    }

}

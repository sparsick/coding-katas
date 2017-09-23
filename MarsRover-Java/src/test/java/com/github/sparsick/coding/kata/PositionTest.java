/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sparsick.coding.kata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *
 * @author sparsick
 */
public class PositionTest {

    @Test
    public void moveBackward_facingDirectionNorth() {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(Direction.NORTH);

        assertThat(newPosition).isEqualTo(new Position(10, 9));
    }

    @Test
    public void moveBackward_facingDirectionEast() {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(Direction.EAST);

        assertThat(newPosition).isEqualTo(new Position(9, 10));
    }

    @Test
    public void moveBackward_facingDirectionSouth() {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(Direction.SOUTH);

        assertThat(newPosition).isEqualTo(new Position(10, 11));
    }

    @Test
    public void moveBackward_facingDirectionWest() {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(Direction.WEST);

        assertThat(newPosition).isEqualTo(new Position(11, 10));
    }

}

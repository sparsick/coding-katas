package com.github.sparsick.coding.kata;

import static com.github.sparsick.coding.kata.Direction.SOUTH;
import static com.github.sparsick.coding.kata.Direction.WEST;

/**
 *
 *
 */
class Rover {

    private final Position position;
    private final Direction direction;

    Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    Position currentPosition() {
        return position;
    }

    Direction currentDirection() {
        return direction;
    }

    void commands(String commands) {
        if (SOUTH.equals(direction)) {
            position.y--;
        } else if (WEST.equals(direction)){
            position.x--;
        }
        else {
            position.y++;
        }
    }

}

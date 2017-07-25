package com.github.sparsick.coding.kata;

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
        position.y++;
    }

}

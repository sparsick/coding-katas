package com.github.sparsick.coding.kata;

/**
 *
 *
 */
class Rover {

    private Position position;
    private Direction direction;

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

        switch (commands) {
            case "l":
                direction = direction.turnLeft();
                break;
            case "r":
                direction = direction.turnRight();
                break;
            case "f":
                position = position.moveForward(direction);
                break;
            case "b":
                position = position.moveBackward(direction);
                break;
        }

    }

}

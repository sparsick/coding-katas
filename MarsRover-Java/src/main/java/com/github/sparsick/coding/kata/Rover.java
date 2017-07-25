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

        if ("f".equals(commands)) {
            moveForward();
        } else {
            moveBackward();
        }

    }

    private void moveBackward() {
        switch (direction) {
            case NORTH:
                position.y--;
                break;
            case SOUTH:
                position.y++;
                break;
            case WEST:
                position.x++;
                break;
            case EAST:
                position.x--;
                break;
        }
    }

    private void moveForward() {
        switch (direction) {
            case NORTH:
                position.y++;
                break;
            case SOUTH:
                position.y--;
                break;
            case WEST:
                position.x--;
                break;
            case EAST:
                position.x++;
                break;
        }
    }

}

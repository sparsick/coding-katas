package com.github.sparsick.coding.kata;

import static com.github.sparsick.coding.kata.Direction.EAST;
import static com.github.sparsick.coding.kata.Direction.SOUTH;
import static com.github.sparsick.coding.kata.Direction.WEST;

/**
 *
 *
 */
class Rover {

    private final Position position;
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
        
        if("l".equals(commands)) {
            turnLeft();
        }

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

    private void turnLeft() {
        switch(direction) {
            case NORTH:
                direction = WEST;
                break;
            case WEST:
                direction = SOUTH;
                break;
            case SOUTH:
                direction = EAST;
                break;
        }
    }

}

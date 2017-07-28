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

        if ("l".equals(commands)) {
            direction = direction.turnLeft();
        }
        
        if("r".equals(commands)) {
            direction = direction.turnRight();
        }

        if ("f".equals(commands)) {
            position = position.moveForward(direction);
        } else {
            position = position.moveBackward(direction);
        }

    }


}

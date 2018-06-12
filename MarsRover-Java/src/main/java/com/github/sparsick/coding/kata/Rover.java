package com.github.sparsick.coding.kata;

/**
 *
 *
 */
class Rover {

    private Position position;
    private Direction direction;
    private PlanetMap planetMap;

    Rover(Position position, Direction direction) {
        this(position, direction, null);
    }

    Rover(Position position, Direction direction, PlanetMap planetMap) {
        this.position = position;
        this.direction = direction;
        this.planetMap = planetMap;
    }

    Position currentPosition() {
        return position;
    }

    Direction currentDirection() {
        return direction;
    }

    void commands(String commands) {
        Position newPostion;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            switch (command) {
                case 'l':
                    direction = direction.turnLeft();
                    break;
                case 'r':
                    direction = direction.turnRight();
                    break;
                case 'f':
                    newPostion = position.moveForward(direction);
                    break;
                case 'b':
                    newPostion = position.moveBackward(direction);
                    break;
            }
        }
        planetMap.checkNew

    }

}

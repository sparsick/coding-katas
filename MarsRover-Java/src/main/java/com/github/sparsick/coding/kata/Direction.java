package com.github.sparsick.coding.kata;

/**
 *
 *
 */
enum Direction {
    NORTH, SOUTH, WEST, EAST;

    public Direction turnLeft() {
        switch (this) {
            case NORTH:
                return WEST;
            case WEST:
                return SOUTH;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            default:
                return null;
        }
    }
}

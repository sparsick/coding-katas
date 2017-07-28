package com.github.sparsick.coding.kata;

/**
 *
 * 
 */
public class Position {
    
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position moveBackward(Direction facingDirection) {
        int newX = x;
        int newY = y;
        switch (facingDirection) {
            case NORTH:
                newY--;
                break;
            case SOUTH:
                newY++;
                break;
            case WEST:
                newX++;
                break;
            case EAST:
                newX--;
                break;
        }
        return new Position (newX, newY);
    }

}

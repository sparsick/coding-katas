package com.github.sparsick.coding.kata;

/**
 *
 * 
 */
public class Position {
    
    private int xCoordinate;
    private int yCoordinate;

    public Position(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Position moveBackward(Direction facingDirection) {
        int newX = xCoordinate;
        int newY = yCoordinate;
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

    public Position moveForward(Direction facingDirection) {
        int newX = xCoordinate;
        int newY = yCoordinate;
        
        switch (facingDirection) {
            case NORTH:
                newY++;
                break;
            case SOUTH:
                newY--;
                break;
            case WEST:
                newX--;
                break;
            case EAST:
                newX++;
                break;
        }
        
        return new Position(newX, newY);
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

}

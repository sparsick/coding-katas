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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.xCoordinate;
        hash = 23 * hash + this.yCoordinate;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.xCoordinate != other.xCoordinate) {
            return false;
        }
        if (this.yCoordinate != other.yCoordinate) {
            return false;
        }
        return true;
    }
    
    

}

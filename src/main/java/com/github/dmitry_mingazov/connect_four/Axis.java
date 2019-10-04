package com.github.dmitry_mingazov.connect_four;

/**
 * Axes that represent the different lines where the discs can be placed
 * to form a winning row
 */
public enum Axis {
    VERTICAL,
    HORIZONTAL,
    DIAGONAL_RIGHT,
    DIAGONAL_LEFT;

    public Direction getFirstDirection(){
        switch(this){
            case VERTICAL:
                return Direction.NORTH;
            case HORIZONTAL:
                return Direction.WEST;
            case DIAGONAL_LEFT:
                return Direction.NORTH_WEST;
            case DIAGONAL_RIGHT:
                return Direction.NORTH_EAST;
        }
        return null;
    }

    public Direction getSecondDirection() {
        switch (this) {
            case VERTICAL:
                return Direction.SOUTH;
            case HORIZONTAL:
                return Direction.EAST;
            case DIAGONAL_LEFT:
                return Direction.SOUTH_EAST;
            case DIAGONAL_RIGHT:
                return Direction.SOUTH_WEST;
        }
        return null;
    }

}

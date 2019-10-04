package com.github.dmitry_mingazov.connect_four;

/**
 * Define the 8 direction where the axes can point to and provide
 * methods to walk recursively these directions
 */
public enum Direction {
    NORTH,
    NORTH_EAST,
    EAST,
    SOUTH_EAST,
    SOUTH,
    SOUTH_WEST,
    WEST,
    NORTH_WEST;

    public int getXStep(){
        if(this == NORTH || this == NORTH_EAST || this == NORTH_WEST)
            return 1;
        if(this == SOUTH || this == SOUTH_EAST || this == SOUTH_WEST)
            return -1;
        return 0;
    }

    public int getYStep(){
        if(this == EAST || this == NORTH_EAST || this == SOUTH_EAST)
            return 1;
        if(this == WEST || this == NORTH_WEST || this == SOUTH_WEST)
            return -1;
        return 0;
    }

}

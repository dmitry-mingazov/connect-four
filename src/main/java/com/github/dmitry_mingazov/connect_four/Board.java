package com.github.dmitry_mingazov.connect_four;

import com.github.dmitry_mingazov.connect_four.exceptions.IllegalMoveException;

/**
 * Manage board, inserting discs into it and check
 * if someone has won the match
 */
public interface Board {
    /**
     * Check the legacy of a move
     * @param column column where the disc would be dropped
     * @return {@code true} if inserting a disc into {@code column} would be possible, {@code false} otherwise
     */
    boolean isLegalMove(int column);

    /**
     * Insert a disc into the passed column if possible
     * @param disc type of disc inserted
     * @param column column where the disc will be inserted
     * @throws IllegalMoveException if column passed is full or not existing
     */
    void insertDisc(Disc disc, int column) throws IllegalMoveException;

    /**
     * Check if the last move was a winning one
     * @return {@code true} if the last move was a winning one
     */
    Disc isLastMoveWinning();

    /**
     *
     * @return height of the board
     */
    int getHeight();

    /**
     *
     * @return width of the board
     */
    int getWidth();

    /**
     * Get the disc at given column and row
     * @param column column where the disc should be taken
     * @param row row where the disc should be taken
     * @return {@code Disc} placed at given {@code column} and {@code row}, {@code Disc.EMPTY} if given coordinates aren't correct
     */
    Disc discAt(int column, int row);

    /**
     * Count how many given discs are placed in a row
     * @param direction direction where the algorithm will search the discs
     * @param disc disc the method will search
     * @param column starting column
     * @param row starting row
     * @return number of discs found at given direction
     */
    int adjacentDiscsIn(Direction direction, Disc disc, int column, int row);

    /**
     * Find the higher placed disc in the given column
     * @param column column where the disc will be searched
     * @return row of higher disc, {@code -1} if the given column does not exist or it is free
     */
    int higherDisc(int column);

    /**
     * Find the lowest free space at given column
     * @param column column where the space will be searched
     * @return row of lowest free space found
     * @throws IllegalMoveException if given column does not exist or it is full
     */
    int lowestFreeSpace(int column) throws IllegalMoveException;
}

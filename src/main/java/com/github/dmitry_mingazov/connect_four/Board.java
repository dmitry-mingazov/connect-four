package com.github.dmitry_mingazov.connect_four;

import com.github.dmitry_mingazov.connect_four.exceptions.IllegalMoveException;

/**
 *
 */
public interface Board {
    /**
     *
     * @param column
     * @return {@code true} if inserting a disc into {@code column} is possible, {@code false} otherwise
     */
    boolean isLegalMove(int column);

    /**
     *
     * @param disc
     * @param column
     * @throws IllegalMoveException
     */
    void insertDisc(Disc disc, int column) throws IllegalMoveException;

    /**
     *
     * @return
     */
    Disc isLastMoveWinning();

    /**
     *
     * @return
     */
    int getHeight();

    /**
     *
     * @return
     */
    int getWidth();

    /**
     *
     * @param column
     * @param row
     * @return
     */
    Disc discAt(int column, int row);

    /**
     *
     * @param direction
     * @param disc
     * @param column
     * @param row
     * @return
     */
    int adjacentDiscsIn(Direction direction, Disc disc, int column, int row);

    /**
     *
     * @param column
     * @return
     */
    int higherDisc(int column);

    /**
     *
     * @param column
     * @return
     * @throws IllegalMoveException
     */
    int lowestFreeSpace(int column) throws IllegalMoveException;
}

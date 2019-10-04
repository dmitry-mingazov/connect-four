package com.github.dmitry_mingazov.connect_four;

import com.github.dmitry_mingazov.connect_four.exceptions.IllegalMoveException;

/**
 * Manage board and players, keeping data about the status
 * of the game
 */
public abstract class Model extends Observable{
    /**
     * Let the player in turn to take an input
     */
    abstract public void takeInput();

    /**
     * Check if a player is taking a input
     * @return {@code true} if someone is taking an input, {@code false} otherwise
     */
    abstract public boolean isTakingInput();

    /**
     * Return Board of match
     * @return {@code Board} of match
     */
    abstract public Board getBoard();

    /**
     * Check a move validity, and register the input
     * @param column column of the move
     * @throws IllegalMoveException if the chosen column is full or does not exists
     */
    abstract public void selectColumn(int column) throws IllegalMoveException;

    /**
     * Insert a disc into the board
     * @throws IllegalMoveException if the chosen column is full or does not exists
     */
    abstract public void insertDisc() throws IllegalMoveException;

    /**
     * Check the board to establish if someone has won
     * @return {@code Player} who has won, {@code null} if there are not winners
     * @throws IllegalStateException if the {@code Disc} of the winner is unknown
     */
    abstract public Player checkWinner() throws IllegalStateException;

    /**
     * Get height of the board
     * @return height of the board
     */
    abstract public int getBoardHeight();

    /**
     * Get width of the board
     * @return width of the board
     */
    abstract public int getBoardWidth();

    /**
     * Get {@code Disc} at given coordinates
     * @param column column where disc will be taken
     * @param row row where disc will be taken
     * @return {@code Disc} at given coordinates
     */
    abstract public Disc getDiscAt(int column, int row);

    /**
     * Change player in turn
     */
    abstract public void changeTurn();

    /**
     * Check if someone has won
     * @return {@code true} if there is a winner, {@code false} otherwise
     */
    abstract public boolean hasWinner();

}

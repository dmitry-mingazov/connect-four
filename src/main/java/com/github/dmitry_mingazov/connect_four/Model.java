package com.github.dmitry_mingazov.connect_four;

import com.github.dmitry_mingazov.connect_four.exceptions.IllegalMoveException;

public abstract class Model extends Observable{
    abstract public void takeInput();
    abstract public boolean isTakingInput();
    abstract public Board getBoard();
    abstract public void selectColumn(int column) throws IllegalMoveException;
    abstract public void insertDisc() throws IllegalMoveException;
    abstract public Player checkWinner() throws IllegalStateException;
    abstract public int getBoardHeight();
    abstract public int getBoardWidth();
    abstract public Disc getDiscAt(int column, int row);
    abstract public void changeTurn();
    abstract public boolean hasWinner();

}

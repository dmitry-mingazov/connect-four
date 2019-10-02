package com.github.dmitry_mingazov.connect_four;

import com.github.dmitry_mingazov.connect_four.exceptions.IllegalMoveException;

public interface Board {
    boolean isLegalMove(int column);
    void insertDisc(Disc disc, int column) throws IllegalMoveException;
    Disc isLastMoveWinning();
    int getHeight();
    int getWidth();
    Disc discAt(int column, int row);
}

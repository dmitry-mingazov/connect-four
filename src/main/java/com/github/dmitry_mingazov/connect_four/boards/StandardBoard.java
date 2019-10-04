package com.github.dmitry_mingazov.connect_four.boards;

import com.github.dmitry_mingazov.connect_four.Axis;
import com.github.dmitry_mingazov.connect_four.Board;
import com.github.dmitry_mingazov.connect_four.Direction;
import com.github.dmitry_mingazov.connect_four.Disc;
import com.github.dmitry_mingazov.connect_four.exceptions.IllegalMoveException;

import java.util.Arrays;
import java.util.EnumSet;

public class StandardBoard implements Board {
    private Disc board[][];
    private int height;
    private int width;
    private int lastColumnSelected;
    private EnumSet<Axis> axes;

    public StandardBoard(){
        this.height = 6;
        this.width = 7;
        this.board = new Disc[this.width][this.height];
        this.lastColumnSelected = -1;
        for(Disc[] row: this.board){
            Arrays.fill(row, Disc.EMPTY);
        }
        axes = EnumSet.allOf(Axis.class);

    }

    @Override
    public boolean isLegalMove(int column){
        if(column > this.width || column < 0){
            return false;
        }else{
            if(this.isColumnFull(column)){
                return false;
            }else{
                return true;
            }
        }
    }

    @Override
    public void insertDisc(Disc disc, int column) throws IllegalMoveException{
        int row = this.lowestFreeSpace(column);
        this.board[column][row] = disc;
        this.lastColumnSelected = column;
    }

    @Override
    public Disc isLastMoveWinning(){
        if(this.lastColumnSelected != -1){
            int row = this.higherDisc(this.lastColumnSelected);
            if(row == -1){
                return Disc.EMPTY;
            }
            Disc turnDisc = this.board[this.lastColumnSelected][row];
            for(Axis axis : axes){
                if(this.adjacentDiscsIn(axis.getFirstDirection(), turnDisc, this.lastColumnSelected, row) +
                   this.adjacentDiscsIn(axis.getSecondDirection(), turnDisc, this.lastColumnSelected, row) >= 5){
                  return turnDisc;
                }
            }
            return Disc.EMPTY;

        }else{
            return Disc.EMPTY;
        }

    }

    @Override
    public int getHeight(){
        return this.height;
    }

    @Override
    public int getWidth(){
        return this.width;
    }

    @Override
    public Disc discAt(int column, int row){
        if(column >= this.width || column < 0 || row >= this.height || row < 0){
            return null;
        }else{
            return this.board[column][row];
        }

    }

    @Override
    public int adjacentDiscsIn(Direction direction, Disc disc, int column, int row){
        if(column >= this.width || column < 0 || row >= this.height || row < 0)
            return 0;
        if(this.board[column][row] == disc){
            return adjacentDiscsIn(direction, disc, column + direction.getXStep(), row + direction.getYStep()) + 1;
        }else{
            return 0;
        }

    }

    private boolean isColumnFull(int column){
        if(this.board[column][this.height - 1] == Disc.EMPTY){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public int lowestFreeSpace(int column) throws IllegalMoveException{
        if(!this.isLegalMove(column)){
           throw new IllegalMoveException("Given column does not exists or it is full!");
        }else{
            for(int i=0; i < this.height; i++){
                if(this.board[column][i] == Disc.EMPTY){
                    return i;
                }
            }
            throw new IllegalMoveException("Unexpected error, check isLegalMove method!");
        }
    }

    @Override
    public int higherDisc(int column){
        for(int i = this.height - 1; i >= 0; i--){
            if(this.board[column][i] != Disc.EMPTY){
                return i;
            }
        }
        return -1;
    }

}

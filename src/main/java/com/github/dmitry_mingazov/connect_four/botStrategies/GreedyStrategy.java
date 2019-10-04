package com.github.dmitry_mingazov.connect_four.botStrategies;

import com.github.dmitry_mingazov.connect_four.*;
import com.github.dmitry_mingazov.connect_four.exceptions.IllegalMoveException;

import java.util.EnumSet;

/**
 * Basic strategy which decides the move according to what it is the best
 * move in that exact moment
 */
public class GreedyStrategy implements BotStrategy {
    private final int winningMove = 10000;
    private final int denyingWinningMove = 9999;
    private EnumSet<Axis> axes;

    public GreedyStrategy(){
        this.axes = EnumSet.allOf(Axis.class);
    }


    @Override
    public int selectColumn(Board board, Disc ownedDisc, Disc opponentsDisc){
        int moveRating = -1;
        int adjOwnedDiscs = 0, adjOpponentDiscs = 0;
        int temp;
        int move = -1;
        int moveHeight = -1;
        int row;
        Direction firstDir, secondDir;


        for(int column = 0; column < board.getWidth(); column++){
            try {
                row = board.lowestFreeSpace(column);
            }catch (IllegalMoveException e){
                continue;
            }
            for(Axis axis : axes){
                firstDir = axis.getFirstDirection();
                secondDir = axis.getSecondDirection();

                temp = board.adjacentDiscsIn(firstDir, ownedDisc, column + firstDir.getXStep(), row + firstDir.getYStep())
                        + board.adjacentDiscsIn(secondDir, ownedDisc, column + secondDir.getXStep(), row + secondDir.getYStep());

                adjOwnedDiscs = temp > adjOwnedDiscs ? temp : adjOwnedDiscs;

                temp = board.adjacentDiscsIn(firstDir, opponentsDisc, column + firstDir.getXStep(), row + firstDir.getYStep())
                        + board.adjacentDiscsIn(secondDir, opponentsDisc, column + secondDir.getXStep(), row + secondDir.getYStep());
                adjOpponentDiscs = temp > adjOpponentDiscs ? temp : adjOpponentDiscs;
                if(adjOwnedDiscs == 3){
                    move = column;
                    moveRating = winningMove;
                    moveHeight = row;
                    adjOwnedDiscs = -1;
                    adjOpponentDiscs = -1;
                    break;
                }else if(adjOpponentDiscs == 3){
                    move = column;
                    moveRating = denyingWinningMove;
                    moveHeight = row;
                    adjOwnedDiscs = -1;
                    adjOpponentDiscs = -1;
                    break;
                }else if(adjOwnedDiscs > moveRating){
                    move = column;
                    moveRating = adjOwnedDiscs;
                    moveHeight = row;
                }else if(adjOwnedDiscs == moveRating){
                    if(row > moveHeight){
                        move = column;
                        moveRating = adjOwnedDiscs;
                        moveHeight = row;
                    }
                }
                adjOpponentDiscs = -1;
                adjOwnedDiscs = -1;


            }


        }
        return move;


    }
}

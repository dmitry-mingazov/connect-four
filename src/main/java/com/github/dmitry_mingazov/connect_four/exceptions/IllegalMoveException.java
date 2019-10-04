package com.github.dmitry_mingazov.connect_four.exceptions;

/**
 * Thrown if something tries to make a illegal move
 */
public class IllegalMoveException extends Exception{
    public IllegalMoveException(String msg){
        super(msg);
    }

    public IllegalMoveException(){
        super("IllegalMoveException: an illegal move was done");
    }
}

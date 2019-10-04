package com.github.dmitry_mingazov.connect_four.models;

import com.github.dmitry_mingazov.connect_four.Board;
import com.github.dmitry_mingazov.connect_four.Disc;
import com.github.dmitry_mingazov.connect_four.Model;
import com.github.dmitry_mingazov.connect_four.Player;
import com.github.dmitry_mingazov.connect_four.exceptions.IllegalMoveException;

public class StandardModel extends Model {
    private Board board;
    private Player players[];
    private int turn;
    private int noPlayers;
    private int currentColumn;
    private boolean takingInput;
    private boolean hasWinner;


    public StandardModel(Board board, Player player1, Player player2){
        super();
        this.noPlayers = 2;
        this.players = new Player[noPlayers];
        this.players[0] = player1;
        this.players[1] = player2;
        this.turn = 0;
        this.board = board;
        this.takingInput = false;
        this.currentColumn = -1;
        this.hasWinner = false;
        notifyObservers(this.board);
    }

    @Override
    public void takeInput(){
        if (this.players[turn].isBot()) {
            do {
                try{
                    this.selectColumn(this.players[turn].selectColumn(board, players[(turn + 1) % this.noPlayers].getDisc()));
                }catch(IllegalMoveException e){
                    continue;
                }
            }while(false);
        } else {
            this.takingInput = true;
            notifyObservers(this.players[turn]);
        }
        this.takingInput = false;
    }

    @Override
    public void insertDisc() throws IllegalMoveException{
       this.board.insertDisc(this.players[turn].getDisc(), this.currentColumn);
       this.currentColumn = -1;
       notifyObservers(this.board);
    }

    @Override
    public Player checkWinner() throws IllegalStateException{
        Disc winnerDisc = this.board.isLastMoveWinning();
        if(winnerDisc == Disc.EMPTY)
            return null;
        else{
            for(Player currPlayer : this.players){
                if(currPlayer.getDisc() == winnerDisc){
                    this.hasWinner = true;
                    notifyObservers(currPlayer);
                    return currPlayer;
                }
            }
            throw new IllegalStateException("Winner disc unknown");
        }
    }
    @Override
    public boolean isTakingInput(){
        return this.takingInput;
    }

    @Override
    public void selectColumn(int column) throws IllegalMoveException{
        if(this.board.isLegalMove(column)) {
            this.currentColumn = column;
        }else{
            throw new IllegalMoveException("Chosen column is unavailable or doesn't exist");
        }
    }

    @Override
    public Board getBoard(){
        return this.board;
    }

    @Override
    public int getBoardHeight(){
        return this.board.getHeight();
    }

    @Override
    public int getBoardWidth(){
        return this.board.getWidth();
    }

    @Override
    public Disc getDiscAt(int column, int row){
        return this.board.discAt(column, row);
    }

    @Override
    public void changeTurn(){
        this.turn = (this.turn + 1) % this.noPlayers;
    }

    @Override
    public boolean hasWinner(){
        return this.hasWinner;
    }
}

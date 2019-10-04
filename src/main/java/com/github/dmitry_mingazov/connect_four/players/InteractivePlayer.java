package com.github.dmitry_mingazov.connect_four.players;

import com.github.dmitry_mingazov.connect_four.*;

public class InteractivePlayer implements Player {
    private Disc disc;
    private String playerName;

    public InteractivePlayer(String playerName, Disc disc){
        this.playerName = playerName;
        this.disc = disc;
    }

    @Override
    public Disc getDisc() {
        return disc;
    }

    @Override
    public boolean isBot(){
        return false;
    }

    @Override
    public String getPlayerName(){
        return playerName;
    }

    @Override
    public int selectColumn(Board board, Disc opponentDisc){
        return -1;
    }

    @Override
    public String toString(){
        return this.playerName;
    }

    @Override
    public void setStrategy(BotStrategy strategy){

    }

}

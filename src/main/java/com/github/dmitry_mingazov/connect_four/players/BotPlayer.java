package com.github.dmitry_mingazov.connect_four.players;

import com.github.dmitry_mingazov.connect_four.Board;
import com.github.dmitry_mingazov.connect_four.BotStrategy;
import com.github.dmitry_mingazov.connect_four.Disc;
import com.github.dmitry_mingazov.connect_four.Player;

/**
 * Automated player, which can use different strategies
 */
public class BotPlayer implements Player {
    private String playerName;
    private Disc disc;
    private BotStrategy strategy;

    public BotPlayer(String playerName, Disc disc){
        this.playerName = playerName;
        this.disc = disc;
        this.strategy = null;
    }

    @Override
    public Disc getDisc(){
        return this.disc;
    }

    @Override
    public boolean isBot(){
        return true;
    }

    @Override
    public int selectColumn(Board board, Disc opponentDisc){
        if(this.strategy == null){
            throw new IllegalStateException("Missing strategy");
        }
        return this.strategy.selectColumn(board, this.disc, opponentDisc);
    }

    @Override
    public void setStrategy(BotStrategy strategy){
        this.strategy = strategy;
    }

    @Override
    public String toString(){
        return this.playerName;
    }

}

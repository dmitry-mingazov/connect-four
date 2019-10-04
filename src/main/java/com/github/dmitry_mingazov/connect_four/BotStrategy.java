package com.github.dmitry_mingazov.connect_four;

/**
 * Strategy that can be used by automated {@code Player} to
 * make decisions about moves
 */
public interface BotStrategy {
    /**
     * Select automagically a column using an algorithm
     * @param board {@code Board} where the game is played
     * @param ownedDisc {@code Disc} of player that is using this strategy
     * @param opponentsDisc {@code Disc} of opponent player
     * @return column where the disc would be placed
     */
    int selectColumn(Board board, Disc ownedDisc, Disc opponentsDisc);
}

package com.github.dmitry_mingazov.connect_four;

/**
 * Player of game, it has a {@code Disc} and can be automated, using
 * different strategies, or interactive
 */
public interface Player {
   /**
    * Get player's disc
    * @return player's {@code Disc}
    */
   Disc getDisc();

   /**
    * Check if the player is real or is automated
    * @return {@code true} if the player is automated, {@code false} otherwise
    */
   boolean isBot();

   /**
    * If the player is automated and has a {@code BotStrategy}, choose a move
    * @param board {@code Board} where the game is played
    * @param opponentDisc {@code Disc} owned by opponent
    * @return column where the disc would be placed
    * @throws IllegalStateException if there are not {@code BotStrategy} loaded
    */
   int selectColumn(Board board, Disc opponentDisc) throws IllegalStateException;

   /**
    * Set the {@code BotStrategy} the automated player will play on
    * @param strategy {@code BotStrategy} the player will use
    */
   void setStrategy(BotStrategy strategy);
}

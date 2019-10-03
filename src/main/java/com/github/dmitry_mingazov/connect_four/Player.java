package com.github.dmitry_mingazov.connect_four;

public interface Player {
   String getPlayerName();
   Disc getDisc();
   boolean isBot();
   int selectColumn(Board board, Disc opponentDisc) throws IllegalStateException;
   void setStrategy(BotStrategy strategy);
}

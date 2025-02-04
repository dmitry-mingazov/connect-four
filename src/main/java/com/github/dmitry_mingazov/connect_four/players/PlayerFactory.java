package com.github.dmitry_mingazov.connect_four.players;

import com.github.dmitry_mingazov.connect_four.Disc;
import com.github.dmitry_mingazov.connect_four.Player;

/**
 * Creates new Players, according to method {@code getPlayer}
 */
public class PlayerFactory {
    public static Player getPlayer(String playerName, Disc disc){
        if(playerName.equalsIgnoreCase("BOT")){
            return new BotPlayer("AI", disc);
        }
        return new InteractivePlayer(playerName, disc);
    }
}

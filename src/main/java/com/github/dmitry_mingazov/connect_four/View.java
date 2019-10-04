package com.github.dmitry_mingazov.connect_four;

/**
 * Display information about status of game, and accepts input for
 * interactive players
 */
public interface View extends Observer{
    /**
     * Enable this view to take input for desired player
     * @param player {@code Player} for whom this view will take input
     */
    void enableInputFor(Player player);
}

package com.github.dmitry_mingazov.connect_four;

/**
 * Manage change made in a {@code Observable} object, and
 * take actions due to these changes
 */
public interface Observer {
    /**
     * Called if a {@code Observable} tracked by this Observer has changed,
     * pull data by that {@code Observable} and by {@code Object} passed
     * @param observable {@code Observable} who has called this method
     * @param obj {@code Object} that can contains information about changed state of {@code Observable{}}
     */
    void update(Observable observable, Object obj);
}

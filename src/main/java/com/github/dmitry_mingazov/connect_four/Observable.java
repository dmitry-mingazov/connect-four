package com.github.dmitry_mingazov.connect_four;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Let one or more {@code Observer} objects to know
 * changes happened to this class
 */
public class Observable {
    private LinkedHashSet<Observer> observers;

    public Observable(){
        observers = new LinkedHashSet<>();
    }

    /**
     * Add an {@code Observer} to list of observers which will
     * be warned about changes happened to this class
     * @param observer {@code Observer} added to list
     */
    void addObserver(Observer observer){
        if(observer == null){
            throw new NullPointerException("Can't add null observer");
        }
        observers.add(observer);
    }

    /**
     * Notify every {@code Observer} which is tracking this object
     * about some changes
     * @param obj information that can be passed
     */
    public void notifyObservers(Object obj){
        Iterator<Observer> iterator = observers.iterator();
        while(iterator.hasNext()){
            iterator.next().update(this, obj);
        }
    }


}

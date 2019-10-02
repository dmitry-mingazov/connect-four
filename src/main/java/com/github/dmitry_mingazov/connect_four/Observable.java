package com.github.dmitry_mingazov.connect_four;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Observable {
    private LinkedHashSet<Observer> observers;

    public Observable(){
        observers = new LinkedHashSet<>();
    }

    void addObserver(Observer observer){
        if(observer == null){
            throw new NullPointerException("Can't add null observer");
        }
        observers.add(observer);
    }

    public void notifyObservers(Object obj){
        Iterator<Observer> iterator = observers.iterator();
        while(iterator.hasNext()){
            iterator.next().update(this, obj);
        }
    }


}

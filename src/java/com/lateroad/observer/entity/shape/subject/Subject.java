package com.lateroad.observer.entity.shape.subject;

import com.lateroad.observer.entity.shape.observer.Observer;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObservers();

    void notifyObservers();
}

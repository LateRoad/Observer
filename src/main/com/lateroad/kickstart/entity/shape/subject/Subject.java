package com.lateroad.kickstart.entity.shape.subject;

import com.lateroad.kickstart.entity.shape.observer.Observer;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObservers();

    void notifyObservers();
}

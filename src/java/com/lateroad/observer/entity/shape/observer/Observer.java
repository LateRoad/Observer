package com.lateroad.observer.entity.shape.observer;

import com.lateroad.observer.entity.shape.AbstractShape;

public interface Observer {
    void valueChanged(AbstractShape observed);
}

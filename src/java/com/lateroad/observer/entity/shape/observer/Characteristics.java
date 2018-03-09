package com.lateroad.observer.entity.shape.observer;

import com.lateroad.observer.action.TetragonAction;
import com.lateroad.observer.entity.shape.AbstractShape;

public class Characteristics implements Observer {
    private float perimeter;
    private float square;

    @Override
    public void valueChanged(AbstractShape observed) {
        TetragonAction action = new TetragonAction();
        perimeter = action.calculatePerimeter(observed);
        square = action.calculateSquare(observed);
    }

    @Override
    public String toString() {
        return "Characteristics{" +
                "perimeter=" + perimeter +
                ", square=" + square +
                '}';
    }
}

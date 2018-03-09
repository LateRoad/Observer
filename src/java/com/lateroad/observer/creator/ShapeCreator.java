package com.lateroad.observer.creator;

import com.lateroad.observer.entity.Point;

public abstract class ShapeCreator {

    public float createSide(Point pointA, Point pointB) {
        return (float)Math.hypot((pointA.getX() - pointB.getX()), (pointA.getY() - pointB.getY()));
    }
}

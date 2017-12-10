package com.lateroad.kickstart.creator;

import com.lateroad.kickstart.entity.Point;

public abstract class ShapeCreator {

    public float createSide(Point pointA, Point pointB) {
        return (float)Math.hypot((pointA.getX() - pointB.getX()), (pointA.getY() - pointB.getY()));
    }
}

package com.lateroad.observer.action;

import com.lateroad.observer.entity.Point;
import com.lateroad.observer.entity.shape.AbstractShape;

public interface IShapeAction {

    float[] calculateSides(Point[] points);

    float calculateSquare(AbstractShape shape);

    float calculatePerimeter(AbstractShape shape);
}

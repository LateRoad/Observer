package com.lateroad.kickstart.action;

import com.lateroad.kickstart.entity.Point;
import com.lateroad.kickstart.entity.shape.AbstractShape;

public interface IShapeAction {

    float[] calculateSides(Point[] points);

    float calculateSquare(AbstractShape shape);

    float calculatePerimeter(AbstractShape shape);
}

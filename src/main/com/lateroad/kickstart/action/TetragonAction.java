package com.lateroad.kickstart.action;

import com.lateroad.kickstart.creator.TetragonCreator;
import com.lateroad.kickstart.entity.Point;
import com.lateroad.kickstart.entity.shape.AbstractShape;

public class TetragonAction implements IShapeAction {

    @Override
    public float[] calculateSides(Point[] points) {
        TetragonCreator creator = new TetragonCreator();
        float[] sides = new float[points.length];
        sides[0] = creator.createSide(points[0], points[1]);
        sides[1] = creator.createSide(points[1], points[2]);
        sides[2] = creator.createSide(points[2], points[3]);
        sides[3] = creator.createSide(points[3], points[0]);
        return sides;
    }

    @Override
    public float calculateSquare(AbstractShape tetragon) {
        float[] sides = calculateSides(tetragon.getPoints());
        float semiPerimeter = (sides[0] + sides[1] + sides[2] + sides[3]) / 2;
        return (float)Math.sqrt((semiPerimeter - sides[0]) *
                (semiPerimeter - sides[1]) *
                (semiPerimeter - sides[2]) *
                (semiPerimeter - sides[3]));
    }

    @Override
    public float calculatePerimeter(AbstractShape tetragon) {
        float[] sides = calculateSides(tetragon.getPoints());
        return sides[0] + sides[1] + sides[2] + sides[3];
    }

    public boolean isTetragon(AbstractShape tetragon) {
        return !(tetragon.getDot(0).equals(tetragon.getDot(1)) ||
                tetragon.getDot(1).equals(tetragon.getDot(2)) ||
                tetragon.getDot(2).equals(tetragon.getDot(3)) ||
                tetragon.getDot(3).equals(tetragon.getDot(0)));
    }

    public boolean isSquare(AbstractShape tetragon) {
        float[] sides = calculateSides(tetragon.getPoints());
        return (sides[0] == sides[1] && sides[1] == sides[2] &&
                sides[2] == sides[3] && sides[3] == sides[0] &&
                Math.pow(sides[0], 2) == calculateSquare(tetragon));
    }
}

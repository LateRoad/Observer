package com.lateroad.kickstart.entity.shape.subject;

import com.lateroad.kickstart.entity.Point;
import com.lateroad.kickstart.entity.shape.AbstractShape;

public class Tetragon extends AbstractShape implements Subject {
    private static final int DOTS_COUNT = 4;

    public Tetragon(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public Tetragon(int[] coordinates) {
        super(coordinates, DOTS_COUNT);
    }

    public Tetragon(Point[] points) {
        super(points, DOTS_COUNT);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Tetragon " + super.toString());
        return info.toString();
    }

}
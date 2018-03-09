package com.lateroad.observer.action;

import com.lateroad.observer.entity.Point;
import com.lateroad.observer.entity.shape.subject.Tetragon;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TetragonActionTest {
    private TetragonAction action;
    private Tetragon tetragon;
    private Point points[] = {new Point(0, 0),
            new Point(3, 0),
            new Point(3, 2),
            new Point(0, 2)};

    @BeforeClass
    public void initTetragon() {
        tetragon = new Tetragon(points);
        action = new TetragonAction();

    }

    @AfterClass
    public void clearTetragon() {
        action = null;
        tetragon = null;
    }

    @Test
    public void calculateSquareTestTrue() {
        double expected = 6.0;
        double actual = action.calculateSquare(tetragon);

        Assert.assertEquals(actual, expected, 1);
    }

    @Test
    public void calculateSquareTestFalse() {
        double expected = 8.0;
        double actual = action.calculateSquare(tetragon);

        Assert.assertFalse(expected == actual);
    }

    @Test
    public void calculatePerimeterTestTrue() {
        double expected = 10.0;
        double actual = action.calculatePerimeter(tetragon);

        Assert.assertEquals(actual, expected, 1);
    }

    @Test
    public void calculatePerimeterTestFalse() {
        double expected = 8.0;
        double actual = action.calculatePerimeter(tetragon);

        Assert.assertFalse(expected == actual);
    }

    @Test
    public void isSquareFalse() {
        Tetragon tetragon = new Tetragon(points);
        Assert.assertFalse(action.isSquare(tetragon));
    }

    @Test
    public void isSquareTrue() {
        Point squarePoints[] = {new Point(0, 0),
                new Point(2, 0),
                new Point(2, 2),
                new Point(0, 2)};
        Tetragon tetragon = new Tetragon(squarePoints);
        action = new TetragonAction();
        Assert.assertTrue(action.isSquare(tetragon));
    }
}
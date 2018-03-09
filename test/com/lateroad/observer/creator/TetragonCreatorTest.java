package com.lateroad.observer.creator;

import com.lateroad.observer.entity.Point;
import com.lateroad.observer.entity.shape.subject.Tetragon;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TetragonCreatorTest {
    TetragonCreator creator = new TetragonCreator();

    @Test
    public void createTetragonTrue() {
        int[] coordinates = {0, 0, 3, 0, 3, 2, 0, 2};
        Point points[] = {new Point(0, 0),
                new Point(3, 0),
                new Point(3, 2),
                new Point(0, 2)};
        Tetragon expected = new Tetragon(points);
        Tetragon actual = creator.createTetragon(coordinates);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void createTetragonFalse() {
        int[] coordinates = {0, 0, 3, 0, 3, 2, 0, 3};
        Point points[] = {new Point(0, 0),
                new Point(3, 0),
                new Point(3, 2),
                new Point(0, 2)};
        Tetragon expected = new Tetragon(points);
        Tetragon actual = creator.createTetragon(coordinates);
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void calculateSideTrue() {
        Point aPoint = new Point(0, 0);
        Point bPoint = new Point(0, 1);
        double expected = 1;
        double actual = creator.createSide(aPoint, bPoint);
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void calculateSideFalse() {
        Point aPoint = new Point(0, 0);
        Point bPoint = new Point(1, 2);
        double expected = 1;
        double actual = creator.createSide(aPoint, bPoint);
        Assert.assertFalse(actual == expected);
    }

}
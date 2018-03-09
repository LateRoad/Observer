package com.lateroad.observer.entity.shape;

import com.lateroad.observer.entity.Point;
import com.lateroad.observer.entity.shape.observer.Observer;
import com.lateroad.observer.entity.shape.subject.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class AbstractShape implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private Point[] points;

    protected AbstractShape(int... coordinates) {
        int dotsCount = coordinates.length / 2;
        this.points = new Point[dotsCount];
        for (int i = 0; i < dotsCount; ++i) {
            this.points[i] = new Point(coordinates[2 * i], coordinates[2 * i + 1]);
        }
    }

    protected AbstractShape(int[] coordinates, int dotsCount) {
        this.points = new Point[dotsCount];
        for (int i = 0; i < dotsCount; ++i) {
            this.points[i] = new Point(coordinates[2 * i], coordinates[2 * i + 1]);
        }
    }

    protected AbstractShape(Point[] points, int dotsCount) {
        this.points = new Point[dotsCount];
        System.arraycopy(points, 0, this.points, 0, dotsCount);
    }

    public Point getDot(int i) {
        return points[i];
    }

    public void setDot(int x, int y, int vertex) {
        points[vertex] = new Point(x, y);
        notifyObservers();
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractShape abstractShape = (AbstractShape) o;
        return Arrays.equals(points, abstractShape.points);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObservers() {
        observers.clear();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.valueChanged(this);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "points=" + Arrays.toString(points) +
                ", observers=" + observers +
                '}';
    }
}


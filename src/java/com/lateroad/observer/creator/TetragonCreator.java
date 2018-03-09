package com.lateroad.observer.creator;

import com.lateroad.observer.entity.shape.subject.Tetragon;

public class TetragonCreator extends ShapeCreator {

    public Tetragon createTetragon(int[] coordinates) {
        return new Tetragon(coordinates);
    }
}

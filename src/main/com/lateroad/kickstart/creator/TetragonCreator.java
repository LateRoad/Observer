package com.lateroad.kickstart.creator;

import com.lateroad.kickstart.entity.shape.subject.Tetragon;

public class TetragonCreator extends ShapeCreator {

    public Tetragon createTetragon(int[] coordinates) {
        return new Tetragon(coordinates);
    }
}

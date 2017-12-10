package com.lateroad.kickstart.entity.shape.observer;

import com.lateroad.kickstart.entity.shape.AbstractShape;

public interface Observer {
    void valueChanged(AbstractShape observed);
}

package com.henmory.designpattern.design_pattern.Tobserver;

/**
 * author: henmory
 * time:  2/28/18
 * function:
 * description:
 */

public class ConcreteSubject extends Subject {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        super.nofifyObserver();
    }
}

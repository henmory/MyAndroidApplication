package com.henmory.designpattern.design_pattern.Tobserver;

/**
 * author: henmory
 * time:  2/28/18
 * function:
 * description:
 */

public class ConcreteObserver implements Observer {
    private int myState;

    @Override
    public void update(Subject subject) {
        myState = ((ConcreteSubject)subject).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}

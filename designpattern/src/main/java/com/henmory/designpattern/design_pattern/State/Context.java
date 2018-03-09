package com.henmory.designpattern.design_pattern.State;

/**
 * author: henmory
 * time:  2/28/18
 * function:
 * description:
 */

public class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
        state.handle();
    }
}

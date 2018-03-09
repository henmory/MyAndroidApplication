package com.henmory.designpattern.design_pattern.State;

/**
 * author: henmory
 * time:  2/28/18
 * function:
 * description:
 */

public class main {
    public static void main(String[] args){
        Context concext = new Context();
        concext.setState(new FreeState());
    }
}

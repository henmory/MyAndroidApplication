package com.henmory.designpattern.design_pattern.Eadapter;

/**
 * author: henmory
 * time:  2/27/18
 * function:
 * description:对象适配器
 */

public class Adapter implements Target{
    Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request();
    }
}

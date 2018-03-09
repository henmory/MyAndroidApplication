package com.henmory.designpattern.design_pattern.Eadapter;

/**
 * author: henmory
 * time:  2/27/18
 * function:
 * description:类适配器
 */

public class Adapter1 extends Adaptee implements Target{

    @Override
    public void handleRequest() {
        super.request();
    }
}

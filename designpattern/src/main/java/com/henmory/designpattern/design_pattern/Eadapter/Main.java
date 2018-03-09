package com.henmory.designpattern.design_pattern.Eadapter;

/**
 * author: henmory
 * time:  2/27/18
 * function:
 * description:
 */

public class Main {

    public static void main(String[] arg){
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.handleRequest();
    }
}

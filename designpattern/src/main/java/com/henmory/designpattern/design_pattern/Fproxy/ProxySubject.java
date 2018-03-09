package com.henmory.designpattern.design_pattern.Fproxy;

/**
 * author: henmory
 * time:  2/27/18
 * function:
 * description:
 */

public class ProxySubject {
    RealSubject realSubject ;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    public void request(){
        realSubject.request();
    }
}

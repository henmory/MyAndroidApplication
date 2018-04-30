package com.henmory.designpattern.design_pattern.Fproxy.dynamicProxy;

/**
 * author: henmory
 * time:  4/7/18
 * function:
 * description: 实际类
 */
public class RealStar implements Star {
    @Override
    public void sing() {
        System.out.println("sing");
    }
}

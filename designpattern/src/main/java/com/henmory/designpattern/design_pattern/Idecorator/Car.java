package com.henmory.designpattern.design_pattern.Idecorator;

/**
 * author: henmory
 * time:  2/11/18
 * function:
 * description: 被装饰的对象，有最基本的功能
 */

public class Car implements Icar {
    @Override
    public void move() {
            System.out.println("我会跑");
    }
}

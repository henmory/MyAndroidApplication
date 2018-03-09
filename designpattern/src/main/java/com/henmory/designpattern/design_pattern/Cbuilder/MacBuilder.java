package com.henmory.designpattern.design_pattern.Cbuilder;

/**
 * author: henmory
 * time:  2/27/18
 * function:
 * description:
 */

public class MacBuilder extends Builder {
    @Override
    void buildBoard() {
        System.out.println("构建mac的board");
    }

    @Override
    void buildScreen() {
        System.out.println("构建mac的screen");

    }

    @Override
    void buildOS() {
        System.out.println("构建mac的os");

    }
}

package com.henmory.designpattern.design_pattern.Cbuilder;

/**
 * author: henmory
 * time:  2/27/18
 * function:
 * description:
 */

public class WindowsBuilder extends Builder {
    @Override
    void buildBoard() {
        System.out.println("构建windows的board");
    }

    @Override
    void buildScreen() {
        System.out.println("构建windows的screen");

    }

    @Override
    void buildOS() {
        System.out.println("构建windows的os");

    }
}

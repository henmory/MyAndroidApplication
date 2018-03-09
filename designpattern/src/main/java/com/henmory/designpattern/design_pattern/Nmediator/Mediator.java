package com.henmory.designpattern.design_pattern.Nmediator;

/**
 * author: henmory
 * time:  2/25/18
 * function:
 * description:
 */

public interface Mediator {
    void register(String name, Department department);
    void command(String name);
}

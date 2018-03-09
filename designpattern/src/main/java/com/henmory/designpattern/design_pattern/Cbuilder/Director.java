package com.henmory.designpattern.design_pattern.Cbuilder;

import android.widget.Button;

/**
 * author: henmory
 * time:  2/27/18
 * function:
 * description:
 */

public class Director {
   private Builder builder = null;

    public Director(Builder builder) {
        this.builder = builder;
    }
    public void construct(){
        builder.buildBoard();
        builder.buildScreen();
        builder.buildOS();
    }
}

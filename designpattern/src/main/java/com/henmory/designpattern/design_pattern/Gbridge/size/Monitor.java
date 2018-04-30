package com.henmory.designpattern.design_pattern.Gbridge.size;


import com.henmory.designpattern.design_pattern.Gbridge.brand.Brand;

/**
 * author: henmory
 * time:  2/7/18
 * function:
 * description:
 */

public abstract class Monitor {
    Brand brand;

    public Monitor(Brand brand) {
        this.brand = brand;
    }

    public void describe(){
        brand.describ();
    }
}

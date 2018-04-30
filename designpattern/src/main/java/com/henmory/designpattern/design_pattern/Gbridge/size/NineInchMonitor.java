package com.henmory.designpattern.design_pattern.Gbridge.size;


import com.henmory.designpattern.design_pattern.Gbridge.brand.Brand;

/**
 * author: henmory
 * time:  2/7/18
 * function:
 * description:
 */

public class NineInchMonitor extends Monitor {
    public NineInchMonitor(Brand brand) {
        super(brand);
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("9英寸显示器");
    }
}

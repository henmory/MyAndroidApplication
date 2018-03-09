package com.henmory.designpattern.design_pattern.Gbridge.size;

import com.changhong.design_pattern.Gbridge.brand.Brand;

/**
 * author: henmory
 * time:  2/7/18
 * function:
 * description:
 */

public class SixteenMonitor extends Monitor {
    public SixteenMonitor(Brand brand) {
        super(brand);
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("这是16英寸显示器");
    }
}

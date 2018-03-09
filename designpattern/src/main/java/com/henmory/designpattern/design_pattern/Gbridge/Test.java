package com.henmory.designpattern.design_pattern.Gbridge;

import com.changhong.design_pattern.Gbridge.brand.Dell;
import com.changhong.design_pattern.Gbridge.brand.Lenovo;
import com.changhong.design_pattern.Gbridge.size.NineInchMonitor;
import com.changhong.design_pattern.Gbridge.size.SixteenMonitor;

/**
 * author: henmory
 * time:  2/7/18
 * function:
 * description:
 */

public class Test {
    public static void main(String[] args){
        NineInchMonitor nineInchMonitor = new NineInchMonitor(new Lenovo());
        nineInchMonitor.describe();

        SixteenMonitor sixteenMonitor = new SixteenMonitor(new Dell());
        sixteenMonitor.describe();
    }
}

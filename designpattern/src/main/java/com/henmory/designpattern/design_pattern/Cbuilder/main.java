package com.henmory.designpattern.design_pattern.Cbuilder;

/**
 * author: henmory
 * time:  2/27/18
 * function:
 * description:
 */

public class main {
     public static void main(String[] arg){
         WindowsBuilder windowsBuilder = new WindowsBuilder();
         MacBuilder macBuilder = new MacBuilder();

         Director director = new Director(windowsBuilder);
         director.construct();

         Director director1 = new Director(macBuilder);
         director1.construct();

    }
}

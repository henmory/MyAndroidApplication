package com.henmory.designpattern.design_pattern.Nmediator;

import java.util.HashMap;
import java.util.Map;

/**
 * author: henmory
 * time:  2/25/18
 * function:
 * description:
 */

public class Manager implements Mediator {
    private Map<String, Department> map = new HashMap<>();

    @Override
    public void register(String name, Department department) {
        map.put(name, department);
    }

    @Override
    public void command(String name) {
        if (name.equals("Development")){
            map.get("Development").selfAction();
        }else if(name.equals("Financial")){
            map.get("Financial").selfAction();
        }else if(name.equals("Market")){
            map.get("Market").selfAction();
        }else{
            System.out.println("null");
        }
    }
}

package com.henmory.designpattern.design_pattern.Lchianofresponsibility;

/**
 * author: henmory
 * time:  2/12/18
 * function:
 * description:
 */

public class Client {

    public static void main(String[] args){

        Leader director = new Director("张三");
        Leader manager = new Manager("李四");
        Leader generalManager = new GeneralManager("王五");
        director.setNextLeader(manager);
        manager.setNextLeader(generalManager);

        LeaveRequest leaveRequest = new LeaveRequest("henmory", "have a rest", 10);

        director.handler(leaveRequest);
    }
}

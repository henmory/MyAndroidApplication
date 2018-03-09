package com.henmory.designpattern.design_pattern.Lchianofresponsibility;

/**
 * author: henmory
 * time:  2/12/18
 * function:
 * description:
 */

public class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }
    @Override
    public void handler(LeaveRequest leaveRequest) {
        if (leaveRequest.getLeaveDays() < 10){
            System.out.println("请假人:" + leaveRequest.getName() + ";请假时间：" + leaveRequest.getLeaveDays()
                                + ";请假原因：" + leaveRequest.getReasons());
            System.out.println(this.name + "批准");
        }else{
            if (this.nextLeader != null){
                System.out.println(this.getClass().getName() + this.name + "不敢批准这个请求，要求上级领导处理");
                this.nextLeader.handler(leaveRequest);
            }
        }
    }
}

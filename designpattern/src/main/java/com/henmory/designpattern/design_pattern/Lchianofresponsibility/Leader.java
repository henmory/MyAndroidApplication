package com.henmory.designpattern.design_pattern.Lchianofresponsibility;

/**
 * author: henmory
 * time:  2/12/18
 * function:
 * description:
 */

public abstract class Leader {
    protected String name;
    protected Leader nextLeader;

    protected Leader(String name){
        this.name = name;
    }

    protected void setNextLeader(Leader nextLeader){
        this.nextLeader = nextLeader;
    }
    protected abstract void handler(LeaveRequest leaveRequest);
}

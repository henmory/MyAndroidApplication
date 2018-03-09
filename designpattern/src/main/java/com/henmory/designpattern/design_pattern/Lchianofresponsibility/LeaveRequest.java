package com.henmory.designpattern.design_pattern.Lchianofresponsibility;

/**
 * author: henmory
 * time:  2/12/18
 * function:
 * description:
 */

public class LeaveRequest {
    private String name;
    private String reasons;
    private int leaveDays;

    public LeaveRequest(String name, String reasons, int leaveDays) {
        this.name = name;
        this.reasons = reasons;
        this.leaveDays = leaveDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }
}

package com.henmory.designpattern.design_pattern.Kflyweight;

/**
 * author: henmory
 * time:  2/11/18
 * function:
 * description:
 */

public class Test {

    public static void main(String[] args){

        Ticket ticket = TicketFactory.getTicket("cd", "bd");
        ticket.showTicketInfo("上铺");
        Ticket ticket1 = TicketFactory.getTicket("cd", "bd");
        ticket1.showTicketInfo("硬座");

    }
}

package com.henmory.designpattern.design_pattern.Kflyweight;

import java.util.Random;

/**
 * author: henmory
 * time:  2/11/18
 * function:
 * description: 具体实现类，factory中存储的就是这样的对象池
 */

public class TrainTicket implements Ticket {

    private String departure;
    private String destination;
    private String type;
    private float price;

    public TrainTicket(String departure, String destination) {
        this.departure = departure;
        this.destination = destination;
    }

    @Override
    public void showTicketInfo(String type) {
        price = new Random().nextInt(300);
        System.out.println("购买" + this.departure + "到" + this.destination + "的" + type + "价格" + this.price);
    }
}

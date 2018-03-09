package com.henmory.designpattern.design_pattern.Kflyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: henmory
 * time:  2/11/18
 * function:
 * description:票的工厂，采用静态方法获取
 */

public class TicketFactory {

    private static Map<String, Ticket> map = new ConcurrentHashMap<>();//多线程同步类库

    public static  Ticket getTicket(String from, String to){
        String flag = from + "--" + to;
        if (map.containsKey(flag)){
            System.out.println("使用缓存===>" + flag);
            return map.get(flag);
        }else{
            Ticket ticket = new TrainTicket(from, to);
            map.put(flag, ticket);
            System.out.println("创建对象====>" + flag);
            return ticket;
        }
    }
}

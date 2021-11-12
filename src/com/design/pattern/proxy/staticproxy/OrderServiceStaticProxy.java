package com.design.pattern.proxy.staticproxy;

import com.design.pattern.proxy.IOrderService;
import com.design.pattern.proxy.Order;
import com.design.pattern.proxy.OrderServiceImpl;

public class OrderServiceStaticProxy {
    private IOrderService orderService;
    public int saveOrder(Order order){
        beforeMethod();
        orderService = new OrderServiceImpl();
        int userId = order.getUserId();
        int dbRouter = userId%2;
        System.out.println("静态代理分配到[db "+dbRouter+" ]处理数据到");
        afterMethod();
        return orderService.saveOrder(order);
    }

    public void beforeMethod(){
        System.out.println("静态代理 before code");
    }

    public void afterMethod(){
        System.out.println("静态代理 after code");

    }
}

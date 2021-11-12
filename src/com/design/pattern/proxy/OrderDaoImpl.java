package com.design.pattern.proxy;

public class OrderDaoImpl implements OrderDao{
    @Override
    public int insert(Order order) {
        System.out.println("插入数据成功");
        return 1;
    }
}

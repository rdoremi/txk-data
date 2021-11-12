package com.design.pattern.proxy;

public class OrderServiceImpl implements IOrderService{

    private OrderDao orderDao;

    @Override
    public int saveOrder(Order order) {
        System.out.println("service--保存数据成功");
        orderDao = new OrderDaoImpl();
        return orderDao.insert(order);
    }


}

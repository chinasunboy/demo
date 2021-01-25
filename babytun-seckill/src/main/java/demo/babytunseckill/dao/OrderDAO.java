package demo.babytunseckill.dao;

import demo.babytunseckill.entity.Order;

public interface OrderDAO {
    public void insert(Order order);

    public Order findByOrderNo(String orderNo);
}

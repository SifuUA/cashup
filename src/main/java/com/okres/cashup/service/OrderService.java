package com.okres.cashup.service;

import com.okres.cashup.Model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrders();

    Order findOrderByClientId(long id);

    List<Order> saveOrder(Order client, long clientId);

    Order confirmClientOrder(Boolean confirm);

}

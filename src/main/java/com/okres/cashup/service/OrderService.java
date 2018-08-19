package com.okres.cashup.service;

import com.okres.cashup.Model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrders();

    List<Order> findOrderByClientId(long id);

    void saveOrder(Order client, long clientId);

    Order confirmClientOrder(Boolean confirm);

}

package com.okres.cashup.service;

import com.okres.cashup.Model.Order;

import java.util.List;

/**
 * Interface with order methods required of task
 */

public interface OrderService {

    List<Order> findAllOrders();

    List<Order> findOrderByClientId(long id);

    void saveOrder(Order client);

    Order confirmClientOrder(long orderId);

}

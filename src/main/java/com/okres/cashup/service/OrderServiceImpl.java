package com.okres.cashup.service;

import com.okres.cashup.Model.Client;
import com.okres.cashup.Model.Order;
import com.okres.cashup.Repository.ClientRepository;
import com.okres.cashup.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Qualifier("orderRepository")
    @Autowired
    private OrderRepository orderRepository;

    @Qualifier("clientRepository")
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    public OrderServiceImpl(@Qualifier("orderRepository") OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrderByClientId(long id) {
        return null;
    }

    @Override
    public List<Order> saveOrder(Order order, long clientId) {
        order.setClientId(clientId);
        orderRepository.save(order);
        return orderRepository.findAll();
    }

    @Override
    public Order confirmClientOrder(Boolean confirm) {
        return null;
    }
}

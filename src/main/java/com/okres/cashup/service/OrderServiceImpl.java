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
    public List<Order> findOrderByClientId(long id) {
        List<Order> orders = orderRepository.findAll();
        for (Order o : orders) {
            if (o.getClientId() == id)
                return orderRepository.findByClientId(id);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void saveOrder(Order order, long clientId) {
        order.setClientId(clientId);
        order.setClient(clientRepository.findById(clientId));
        orderRepository.save(order);
    }

    @Override
    public Order confirmClientOrder(Boolean confirm) {
        return null;
    }
}

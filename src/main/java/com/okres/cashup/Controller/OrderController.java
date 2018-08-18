package com.okres.cashup.Controller;

import com.okres.cashup.Model.Order;
import com.okres.cashup.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private OrderRepository orderRepository;

    @Autowired
    public OrderController(@Qualifier("orderRepository") OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value = "/all")
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Order> create(@RequestBody Order order) {
        orderRepository.save(order);
        return orderRepository.findAll();
    }
}

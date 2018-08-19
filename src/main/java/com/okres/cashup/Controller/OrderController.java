package com.okres.cashup.Controller;

import com.okres.cashup.Model.Order;
import com.okres.cashup.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/all")
    public List<Order> getAll() {
        return orderService.findAllOrders();
    }

    @RequestMapping(value = "/create/{clientId}", method = RequestMethod.POST)
    public List<Order> create(@PathVariable("clientId") long id,
                              @RequestBody Order order) {
        orderService.saveOrder(order, id);
        return orderService.findAllOrders();
    }
}

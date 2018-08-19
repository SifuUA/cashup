package com.okres.cashup.Controller;

import com.okres.cashup.Model.Order;
import com.okres.cashup.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Order> create(@RequestBody Order order) {
        orderService.saveOrder(order);
        return orderService.findAllOrders();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Order> getAllClientOrdersByClientId(@PathVariable("id") long clientId) {
        return orderService.findOrderByClientId(clientId);
    }

    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.POST)
    public Order confirmOrder(@PathVariable("id") long id) {
        return orderService.confirmClientOrder(id);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Request ID not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badExceptionHandler() {
    }
}

package com.okres.cashup.Service;

import com.okres.cashup.Model.Order;
import com.okres.cashup.Repository.ClientRepository;
import com.okres.cashup.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementation methods from order interface, layer between
 * business logic and view.
 */

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
    public void saveOrder(Order order) {
        order.setClient(clientRepository.findById(order.getClientId()));
        orderRepository.save(order);
    }

    @Override
    public Order confirmClientOrder(long orderId) {
        Order clone = new Order(orderRepository.findById(orderId));
        orderRepository.deleteById(orderId);
        clone.setStatus(true);
        orderRepository.save(clone);
        return clone;
    }
}

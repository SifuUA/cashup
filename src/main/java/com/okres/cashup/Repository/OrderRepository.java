package com.okres.cashup.Repository;

import com.okres.cashup.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClientId(long id);
}

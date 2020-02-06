package com.orders.management.users.services;

import com.orders.management.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {

    int addOrder(Order order);
    void update(Order order);
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Integer id);
    void deleteOrder(Integer id);

}

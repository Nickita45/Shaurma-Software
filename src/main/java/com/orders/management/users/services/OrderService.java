package com.orders.management.users.services;

import com.orders.management.domain.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    int addOrder(Order order);
    void deleteOrder(int id);

}

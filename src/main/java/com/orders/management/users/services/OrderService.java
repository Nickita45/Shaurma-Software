package com.orders.management.users.services;

import com.orders.management.domain.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    int addOrder(Document document);
    Document update(Document document);
    List<Document> getAllOrders();
    Document getOrderById(Integer id);
    void deleteOrder(Integer id);

}

package com.orders.management.users.services;

        import com.orders.management.domain.Document;
        import com.orders.management.users.repository.OrderRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.time.LocalDateTime;
        import java.util.Date;
        import java.util.List;
        import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public int addOrder(Document document) {
        return orderRepository.save(document).getId();
    }

    @Override
    public Document update(Document document) {
        if(document.getId() != null) {
            LocalDateTime date = LocalDateTime.now();
            document.setDate(date);
            return orderRepository.save(document);
        }
        else return new Document();
    }

    @Override
    public List<Document> getAllOrders() {
        return (List<Document>) orderRepository.findAll();
    }

    @Override
    public Document getOrderById(Integer id) {
        Optional<Document> optional = orderRepository.findById(id);
        Document order = new Document();
        if(optional.isPresent()){
            order = optional.get();
        }
        return order;
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}

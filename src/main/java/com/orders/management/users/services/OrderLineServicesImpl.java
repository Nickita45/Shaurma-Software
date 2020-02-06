package com.orders.management.users.services;

import com.orders.management.domain.Additive;
import com.orders.management.domain.ShaurmaType;
import com.orders.management.domain.Spice;
import com.orders.management.users.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineServicesImpl implements OrderLineServices{

    @Autowired
    private OrderLineRepository orderline;
    @Override
    public long removeAdditive(int id) {
        orderline.deleteById(id);
        return id;
    }

    @Override
    public void removeAllAdditive() {
        orderline.deleteAll();
    }

    @Override
    public List<Additive> getAllAdditives() {
        return (List<Additive>) orderline.findAll();
    }

    @Override
    public void addNewTypeShaurma(ShaurmaType type) {

    }

    @Override
    public void addNewSpice(Spice spic) {

    }

    @Override
    public long addNewAdditive(Additive addes) {
        orderline.save(addes);
        return addes.getId();
    }
}

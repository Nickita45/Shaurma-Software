package com.orders.management.users.services;

import com.orders.management.domain.ShaurmaType;
import com.orders.management.domain.Spice;
import com.orders.management.users.repository.ShaurmaTypeRepository;
import com.orders.management.users.repository.SpicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShaurmaTypeServicesImpl implements ShaurmaTypeServices{

    @Autowired
    private ShaurmaTypeRepository orderline;
    @Override
    public int removeShaurmaType(int id) {
        orderline.deleteById(id);
        return id;
    }

    @Override
    public List<ShaurmaType> getAllShaurmaTypes() {
        return (List<ShaurmaType>) orderline.findAll();
    }

    @Override
    public int addNewShaurma(ShaurmaType addes) {

        return  orderline.save(addes).getId();
    }

    @Override
    public ShaurmaType findbyId(int id) {
        return orderline.findById(id).get();
    }
}

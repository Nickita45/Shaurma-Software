package com.orders.management.users.services;

import com.orders.management.domain.Additive;
import com.orders.management.users.repository.AdditivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AdditivesServicesImpl implements AdditivesServices{

    @Autowired
    private AdditivesRepository orderline;
    @Override
    public int removeAdditive(int id) {
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
    public int addNewAdditive(Additive addes) {

        return  orderline.save(addes).getId();
    }

    @Override
    public Set<Additive> findByAdditiveIds(Set<Integer> additiveIdList) {
        return orderline.findByAdditiveIds(additiveIdList);
    }
}

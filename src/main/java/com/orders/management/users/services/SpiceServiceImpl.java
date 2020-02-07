package com.orders.management.users.services;

import com.orders.management.domain.Additive;
import com.orders.management.domain.Spice;
import com.orders.management.users.repository.AdditivesRepository;
import com.orders.management.users.repository.SpicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SpiceServiceImpl implements SpiceServices{

    @Autowired
    private SpicesRepository orderline;
    @Autowired
    private AdditivesRepository additivesRepository;
    @Override
    public int removeSpice(int id) {
        orderline.deleteById(id);
        return id;
    }

    @Override
    public List<Spice> getAllSpices() {
        return (List<Spice>) orderline.findAll();
    }

    @Override
    public int addNewSpice(Spice addes) {

        return orderline.save(addes).getId();
    }

    @Override
    public Set<Spice> findBySpiceIds(Set<Integer> spiceIdList) {
        return orderline.findBySpiceIds(spiceIdList);
    }
}

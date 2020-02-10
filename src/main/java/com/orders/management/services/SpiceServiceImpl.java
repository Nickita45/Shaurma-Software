package com.orders.management.services;

import com.orders.management.domain.Spice;
import com.orders.management.repository.AdditivesRepository;
import com.orders.management.repository.SpicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SpiceServiceImpl implements SpiceServices{

    @Autowired
    private SpicesRepository spicesRepository;
    @Autowired
    private AdditivesRepository additivesRepository;
    @Override
    public int removeSpice(int id) {
        spicesRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Spice> getAllSpices() {
        return (List<Spice>) spicesRepository.findAll();
    }

    @Override
    public int addNewSpice(Spice addes) {

        return spicesRepository.save(addes).getId();
    }

    @Override
    public Set<Spice> findBySpiceIds(Set<Integer> spiceIdList) {
        return spicesRepository.findBySpiceIds(spiceIdList);
    }
}

package com.orders.management.services;

import com.orders.management.domain.Spice;
import com.orders.management.repository.AdditivesRepository;
import com.orders.management.repository.SpicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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


   // @Secured({"ADMIN","USER"})
    @Secured("ROLE_ADMIN")
    @Override
    public List<Spice> getAllSpices() {
        return (List<Spice>) spicesRepository.findAll();
    }


   // @Secured("ADMIN")
    @Secured("ROLE_ADMIN")
    @Override
    public int addNewSpice(Spice addes) {

        return spicesRepository.save(addes).getId();
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN","ROLE_CASHIER"})
    @Override
    public Set<Spice> findBySpiceIds(Set<Integer> spiceIdList) {
        return spicesRepository.findBySpiceIds(spiceIdList);
    }
}

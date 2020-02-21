package com.orders.management.services;

import com.orders.management.domain.Additive;
import com.orders.management.repository.AdditivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AdditivesServicesImpl implements AdditivesServices{

    @Autowired
    private AdditivesRepository additivesRepository;
    @Secured("ROLE_ADMIN")
    @Override
    public int removeAdditive(int id) {
        additivesRepository.deleteById(id);
        return id;
    }
    @Secured("ROLE_ADMIN")
    @Override
    public void removeAllAdditive() {
        additivesRepository.deleteAll();
    }

    @Override
    public List<Additive> getAllAdditives() {
        return (List<Additive>) additivesRepository.findAll();
    }
    @Secured("ROLE_ADMIN")
    @Override
    public int addNewAdditive(Additive addes) {

        return  additivesRepository.save(addes).getId();
    }

    @Override
    public Set<Additive> findByAdditiveIds(Set<Integer> additiveIdList) {
        return additivesRepository.findByAdditiveIds(additiveIdList);
    }
}

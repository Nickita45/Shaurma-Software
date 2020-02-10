package com.orders.management.services;

import com.orders.management.domain.ShaurmaType;
import com.orders.management.repository.ShaurmaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShaurmaTypeServicesImpl implements ShaurmaTypeServices{

    @Autowired
    private ShaurmaTypeRepository shaurmaTypeRepository;
    @Override
    public int removeShaurmaType(int id) {
        shaurmaTypeRepository.deleteById(id);
        return id;
    }

    @Override
    public List<ShaurmaType> getAllShaurmaTypes() {
        return (List<ShaurmaType>) shaurmaTypeRepository.findAll();
    }

    @Override
    public int addNewShaurma(ShaurmaType shaurmaType) {

        return  shaurmaTypeRepository.save(shaurmaType).getId();
    }

    @Override
    public ShaurmaType findbyId(int id) {
        return shaurmaTypeRepository.findById(id).get();
    }
}

package com.orders.management.services;

import com.orders.management.domain.ShaurmaType;

import java.util.List;

public interface ShaurmaTypeServices {
    int removeShaurmaType(int id);
    List<ShaurmaType> getAllShaurmaTypes();
    int addNewShaurma(ShaurmaType shaurmaType);
    ShaurmaType findbyId(int id);
}

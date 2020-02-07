package com.orders.management.users.services;

import com.orders.management.domain.Additive;
import com.orders.management.domain.ShaurmaType;

import java.util.List;

public interface ShaurmaTypeServices {
    int removeShaurmaType(int id);
    List<ShaurmaType> getAllShaurmaTypes();
    int addNewShaurma(ShaurmaType addes);
    ShaurmaType findbyId(int id);
}

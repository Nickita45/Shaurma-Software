package com.orders.management.services;

import com.orders.management.domain.Additive;

import java.util.List;
import java.util.Set;

public interface AdditivesServices {
    int removeAdditive(int id);
    void removeAllAdditive();
    List<Additive> getAllAdditives();
    int addNewAdditive(Additive addes);
    Set<Additive> findByAdditiveIds(Set<Integer> additiveIdList);
}

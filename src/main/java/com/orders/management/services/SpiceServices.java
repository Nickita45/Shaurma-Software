package com.orders.management.services;

import com.orders.management.domain.Spice;

import java.util.List;
import java.util.Set;

public interface SpiceServices {
    int removeSpice(int id);
    List<Spice> getAllSpices();
    int addNewSpice(Spice spice);
    Set<Spice> findBySpiceIds(Set<Integer> spiceIdList);
}

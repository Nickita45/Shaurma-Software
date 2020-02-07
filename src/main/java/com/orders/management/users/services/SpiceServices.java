package com.orders.management.users.services;

import com.orders.management.domain.Additive;
import com.orders.management.domain.Spice;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface SpiceServices {
    int removeSpice(int id);
    List<Spice> getAllSpices();
    int addNewSpice(Spice addes);
    Set<Spice> findBySpiceIds(Set<Integer> spiceIdList);
}

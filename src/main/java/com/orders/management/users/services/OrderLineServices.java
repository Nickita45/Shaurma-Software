package com.orders.management.users.services;

import com.orders.management.domain.Additive;
import com.orders.management.domain.ShaurmaType;
import com.orders.management.domain.Spice;

import java.util.List;
import java.util.Set;

public interface OrderLineServices {
    int removeAdditive(int id);
    void removeAllAdditive();
    List<Additive> getAllAdditives();

    void addNewTypeShaurma(ShaurmaType type);
    void addNewSpice(Spice spic);
    int addNewAdditive(Additive addes);

}

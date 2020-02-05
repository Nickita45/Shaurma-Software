package com.orders.management.users.services;

import com.orders.management.domain.Additive;
import com.orders.management.domain.ShaurmaType;
import com.orders.management.domain.Spice;

public interface OrderLineServices {
    long removeAdditive(long id);
    void removeAllAdditive();

    void addNewTypeShaurma(ShaurmaType type);
    void addNewSpice(Spice spic);
    void addNewAdditive(Additive addes);
}

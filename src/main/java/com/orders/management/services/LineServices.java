package com.orders.management.users.services;

import com.orders.management.domain.Line;
import com.orders.management.domain.ShaurmaType;
import com.orders.management.users.resources.RequestLine;

import java.util.List;

public interface LineServices {
    int removeLine(int id);
    List<Line> getAllLine();
    int addNewLine(RequestLine addes);
}

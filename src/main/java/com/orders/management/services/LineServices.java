package com.orders.management.services;

import com.orders.management.domain.Line;
import com.orders.management.resources.RequestLine;

import java.util.List;

public interface LineServices {
    int removeLine(int id);
    List<Line> getAllLine();
    int addNewLine(RequestLine requestLine);
}

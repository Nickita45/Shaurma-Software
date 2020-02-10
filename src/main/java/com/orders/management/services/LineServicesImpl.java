package com.orders.management.users.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.management.domain.Additive;
import com.orders.management.domain.Line;
import com.orders.management.domain.ShaurmaType;
import com.orders.management.domain.Spice;
import com.orders.management.users.repository.AdditivesRepository;
import com.orders.management.users.repository.LineRepository;
import com.orders.management.users.repository.ShaurmaTypeRepository;
import com.orders.management.users.repository.SpicesRepository;
import com.orders.management.users.resources.RequestLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LineServicesImpl implements LineServices{

    @Autowired
    private LineRepository orderline;
    @Autowired
    private AdditivesServices additivesServices;
    @Autowired
    private SpiceServices spiceService;
    @Autowired
    private ShaurmaTypeServices shaurmaTypeServices;

    private ObjectMapper mapper;

    @Override
    public int removeLine(int id) {
        orderline.deleteById(id);
        return id;
    }

    @Override
    public List<Line> getAllLine() {
        return (List<Line>) orderline.findAll();
    }

    @Override
    public int addNewLine(RequestLine requestLine) {
        Line line1 = new Line();
        line1.setShaurmaTypeId(shaurmaTypeServices.findbyId(requestLine.getShaurmaTypeId()));
        line1.setDescription(requestLine.getDescription());
        line1.setOrder_id(requestLine.getOrder_id());
        line1.setUser_id(requestLine.getUser_id());
        line1.setAdditive_ids(additivesServices.findByAdditiveIds(requestLine.getAdditiveIds()));
        line1.setSpice_id(spiceService.findBySpiceIds(requestLine.getSpiceIds()));


        return orderline.save(line1).getId();
    }

}

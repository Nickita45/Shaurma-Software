package com.orders.management.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.management.domain.Line;
import com.orders.management.repository.LineRepository;
import com.orders.management.resources.RequestLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineServicesImpl implements LineServices{

    @Autowired
    private LineRepository lineRepository;
    @Autowired
    private AdditivesServices additivesServices;
    @Autowired
    private SpiceServices spiceService;
    @Autowired
    private ShaurmaTypeServices shaurmaTypeServices;

    private ObjectMapper mapper;

    @Override
    public int removeLine(int id) {
        lineRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Line> getAllLine() {
        return (List<Line>) lineRepository.findAll();
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


        return lineRepository.save(line1).getId();
    }

}

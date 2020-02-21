package com.orders.management.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.management.domain.Document;
import com.orders.management.domain.Line;
import com.orders.management.repository.LineRepository;
import com.orders.management.resources.RequestLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Autowired
    private DocumentService documentService;
    @Autowired
    private UserServices userServices;

    private ObjectMapper mapper;

    @Override
    public int removeLine(int id) {
        lineRepository.deleteById(id);
        return id;
    }
    @Secured("ROLE_ADMIN")
    @Override
    public List<Line> getAllLine() {
        return (List<Line>) lineRepository.findAll();
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})
    @Override
    public int addNewLine(RequestLine requestLine) {
        Line line1 = new Line();
        line1.setShaurmaTypeId(shaurmaTypeServices.findbyId(requestLine.getShaurmaTypeId()));
        line1.setDescription(requestLine.getDescription());
        line1.setOrder_id(documentService.getDocumentById(requestLine.getOrder_id()));
        line1.setUser_id(userServices.getUser(requestLine.getUser_id()));
        line1.setAdditive_ids(additivesServices.findByAdditiveIds(requestLine.getAdditiveIds()));
        line1.setSpice_id(spiceService.findBySpiceIds(requestLine.getSpiceIds()));


        return lineRepository.save(line1).getId();
    }

    @Override
    public Line findbyId(int id) {
        Optional<Line> optional = lineRepository.findById(id);
        Line line1 = new Line();
        if(optional.isPresent()){
            line1 = optional.get();
        }
        return line1;
    }

}

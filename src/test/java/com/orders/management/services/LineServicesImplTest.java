package com.orders.management.services;

import com.orders.management.domain.*;
import com.orders.management.repository.LineRepository;
import com.orders.management.repository.SpicesRepository;
import com.orders.management.resources.RequestLine;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class LineServicesImplTest {
    @InjectMocks
    private LineServicesImpl lineServices;

    @Mock
    private LineRepository lineRepository;

    public void addRepositoryObj(Line line)
    {
        line.setDescription("Description "+line.getId());
        line.setUser_id(new User());
        line.setOrder_id(new Document());
        line.setShaurmaTypeId(new ShaurmaType());
       // line.setSpice_id(new Set);

    }
    @Test
    void removeLine() {
    }

    @Test
    void getAllLine() {
    }

    @Test
    void addNewLine() {
        Line line1 = new Line();
        addRepositoryObj(line1);
        when(lineRepository.save(line1)).thenReturn(line1);
        RequestLine requestLine = new RequestLine();

        requestLine.setDescription(line1.getDescription());
        requestLine.setOrder_id(0);
        requestLine.setShaurmaTypeId(0);
        requestLine.setUser_id(0);
        Set<Integer> set1 = new HashSet<Integer>();
        set1.add(1);
        set1.add(2);
        requestLine.setSpiceIds(set1);
        requestLine.setAdditiveIds(set1);
//        int result = lineServices.addNewLine(requestLine);
 //       assertNotNull(result);
  //      assertEquals(result, line1.getId());
    }
}
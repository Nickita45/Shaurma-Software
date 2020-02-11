package com.orders.management.resources;

import com.orders.management.domain.Line;
import com.orders.management.services.LineServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/line")
public class LineController {
    @Autowired
    private LineServices serv;

    @PutMapping
    public int addLine(@RequestBody RequestLine requestLine) {


        return serv.addNewLine(requestLine);
    }
    @GetMapping
    public List<Line> getAllLines() {
        return serv.getAllLine();
    }
    @DeleteMapping
    public int deleteLine(@RequestParam int id) { return serv.removeLine(id);}
}

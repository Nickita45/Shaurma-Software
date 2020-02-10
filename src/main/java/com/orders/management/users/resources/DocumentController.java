package com.orders.management.users.resources;


import com.orders.management.domain.Document;
import com.orders.management.users.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PutMapping
    public int addDocument(@RequestBody Document document){
        return documentService.addDocument(document);
    }

    @GetMapping
    public List<Document> getAllDocument(){
        return documentService.getAllDocuments();
    }

    @DeleteMapping
    public void deleteDocument(@RequestParam Integer id){
        documentService.deleteDocument(id);
    }

    @PostMapping
    public Document update(@RequestBody Document document){
        return documentService.update(document);
    }

    @GetMapping("/id")
    public Document getDocumentById(@RequestParam Integer id){
        return documentService.getDocumentById(id);
    }
}

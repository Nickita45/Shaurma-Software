package com.orders.management.services;

import com.orders.management.domain.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentService {

    int addDocument(Document document);
    Document update(Document document);
    List<Document> getAllDocuments();
    Document getDocumentById(Integer id);
    void deleteDocument(Integer id);

}

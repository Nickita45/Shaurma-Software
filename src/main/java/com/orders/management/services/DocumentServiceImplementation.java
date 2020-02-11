package com.orders.management.services;

        import com.orders.management.domain.Document;

        import com.orders.management.repository.DocumentRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public class DocumentServiceImplementation implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public int addDocument(Document document) {
        document.setDate();
        return documentRepository.save(document).getId();
    }

    @Override
    public Document update(Document document) {
        //if(document.getId() != null) {
        Optional<Document> optional = documentRepository.findById(document.getId());
        if(optional.isPresent())
            return documentRepository.save(document);
        //}
        else return new Document();
    }

    @Override
    public List<Document> getAllDocuments() {
        return (List<Document>) documentRepository.findAll();
    }

    @Override
    public Document getDocumentById(Integer id) {
        Optional<Document> optional = documentRepository.findById(id);
        Document document = new Document();
        if(optional.isPresent()){
            document = optional.get();
        }
        return document;
    }

    @Override
    public void deleteDocument(Integer id) {
        documentRepository.deleteById(id);
    }
}

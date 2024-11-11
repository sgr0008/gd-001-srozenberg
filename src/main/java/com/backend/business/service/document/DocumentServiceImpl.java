package com.backend.business.service.document;

import com.backend.domain.model.Document;
import com.backend.infrastructure.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }


    @Override
    public  Document updatedocument(long documentID, Document document){
       Document documentacionDB= this.findById(documentID).orElse(null);
      if(documentacionDB.equals(null))
          this.save(document);
      return document;

    }
    @Override
    public Document save(Document documentAlta) {
        return documentRepository.save(documentAlta);
    }
    @Override
    public Optional<Document> findById(Long id) {
        return documentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        documentRepository.deleteById(id);
    }

}
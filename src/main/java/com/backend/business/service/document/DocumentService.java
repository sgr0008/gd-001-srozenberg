package com.backend.business.service.document;

import com.backend.domain.model.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentService {

    List<Document> findAll();

    Document save(Document documentAlta);

    Optional<Document> findById(Long id);

    void deleteById(Long id);

    Document updatedocument(long documentID, Document document);

}

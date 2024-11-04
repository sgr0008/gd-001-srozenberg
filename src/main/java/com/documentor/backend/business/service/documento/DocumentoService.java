package com.documentor.backend.casodeuso.service.documento;

import com.documentor.backend.domain.model.Documento;

import java.util.List;
import java.util.Optional;

public interface DocumentoService {

    List<Documento> findAll();

    Documento save(Documento documentoAlta);

    Optional<Documento> findById(Long id);

    void deleteById(Long id);

    Documento updateDocumento(long documentoID, Documento documento);

}

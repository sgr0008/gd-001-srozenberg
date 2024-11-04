package com.documentador.backend.casodeuso.service.documento;

import com.documentador.backend.dominio.model.Documento;
import com.documentador.backend.dominio.model.Documento;

import java.util.List;
import java.util.Optional;

public interface DocumentoService {

    List<Documento> findAll();

    Documento save(Documento documentoAlta);

    Optional<Documento> findById(Long id);

    void deleteById(Long id);

    Documento updateDocumento(long documentoID, Documento documento);

}

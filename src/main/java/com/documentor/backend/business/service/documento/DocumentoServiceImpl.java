package com.documentor.backend.casodeuso.service.documento;

import com.documentor.backend.domain.model.Documento;
import com.documentor.backend.infrastructure.repositories.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoServiceImpl implements DocumentoService {
    @Autowired
    private DocumentoRepository documentoRepository;

    @Override
    public List<Documento> findAll() {
        return documentoRepository.findAll();
    }


    @Override
    public  Documento updateDocumento(long documentoID, Documento documento){
       Documento documentacionDB= this.findById(documentoID).orElse(null);
      if(documentacionDB.equals(null))
          this.save(documento);
      return documento;

    }
    @Override
    public Documento save(Documento documentoAlta) {
        return documentoRepository.save(documentoAlta);
    }
    @Override
    public Optional<Documento> findById(Long id) {
        return documentoRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        documentoRepository.deleteById(id);
    }

}
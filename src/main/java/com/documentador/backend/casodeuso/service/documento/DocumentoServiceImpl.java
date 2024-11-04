package com.documentador.backend.casodeuso.service.documento;

import com.documentador.backend.dominio.model.Documento;
import com.documentador.backend.infraestructura.repositories.DocumentoRepository;
import com.documentador.backend.infraestructura.repositories.InfoRepository;
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
    public  Documento updateInfo(long usuarioID, Documento Documento){
       Documento documentacionDB= this.findById(usuarioID).orElse(null);
      if(documentacionDB.equals(null))
          this.save(Documento);
      return Documento;

    }
    @Override
    public Documento save(Documento infoAlta) {
        return documentoRepository.save(infoAlta);
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
package com.documentador.backend.repositories;

import com.documentador.backend.dominio.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    List<Documento> findAll();
    List<Documento>  findByNombre(String documentoNombre);
    List<Documento>  findByFechaCreacion(int fechaCreacion);
    Documento findById(int id);

}

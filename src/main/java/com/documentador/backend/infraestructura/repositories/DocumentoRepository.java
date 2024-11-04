package com.documentador.backend.infraestructura.repositories;

import com.documentador.backend.dominio.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}

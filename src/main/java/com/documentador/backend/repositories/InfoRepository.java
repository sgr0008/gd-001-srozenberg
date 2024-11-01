package com.documentador.backend.repositories;

import com.documentador.backend.dominio.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {

    List<Info> findAll();
    List<Info> findByNombre(String nombre);
    //List<Info> findByFechaCreacion(int fechaCreacion);
    Info findById(int id);

}

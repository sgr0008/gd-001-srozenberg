package com.documentador.backend.infraestructura.repositories;

import com.documentador.backend.dominio.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {


}

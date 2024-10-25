package com.desa.documentador.backend.repositories;

import com.desa.documentador.dominio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAll();
    Usuario findByNombre(String nombre);
    List<Usuario> findByFechaCreacion(int fechaCreacion);

}

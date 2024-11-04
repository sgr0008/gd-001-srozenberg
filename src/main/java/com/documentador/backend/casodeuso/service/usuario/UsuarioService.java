package com.documentador.backend.casodeuso.service.usuario;

import com.documentador.backend.dominio.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> findAll();

    Usuario save(String name, int fechaCreacion);
    Usuario save(Usuario usuaroAlta);

    Optional<Usuario> findById(Long id);

    void deleteById(Long id);

    Usuario updateUsuario(long usuarioID, Usuario usuario);

}

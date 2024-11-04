package com.documentador.backend.casodeuso.service.usuario;

import com.documentador.backend.dominio.model.Usuario;
import com.documentador.backend.infraestructura.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(String name,int fechaCreacion) {
        Usuario usuaroAlta=new Usuario();
        usuaroAlta.setName(name);
        usuaroAlta.setFechaCreacion(fechaCreacion);
        return usuarioRepository.save(usuaroAlta);
    }
    @Override
    public  Usuario updateUsuario(long usuarioID, Usuario usuario){
       Usuario usuarioDB= this.findById(usuarioID).orElse(null);
      if(usuarioDB.equals(null))
          this.save(usuario);
      return usuario;

    }
    @Override
    public Usuario save(Usuario usuaroAlta) {
        return usuarioRepository.save(usuaroAlta);
    }
    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }


}
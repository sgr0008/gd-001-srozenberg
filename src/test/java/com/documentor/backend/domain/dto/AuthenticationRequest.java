package com.documentor.backend.domain.dto;

import com.documentor.backend.casodeuso.service.usuario.UsuarioService;
import com.documentor.backend.infrastructure.repositories.DocumentoRepository;
import jakarta.validation.constraints.NotBlank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticationRequest {
    @NotBlank
    private String username;
    private String password;

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @SpringBootTest
    @ActiveProfiles("test")
    static
    class DocumentadorApplicationTests {
     @Autowired
     DocumentoRepository documentoRepositoryrepo;
     @Autowired
     UsuarioService usuarioService;



        @Test
        public void findAllDocumento(){
            Assertions.assertTrue(!documentoRepositoryrepo.findAll().isEmpty());
        }

    }
}

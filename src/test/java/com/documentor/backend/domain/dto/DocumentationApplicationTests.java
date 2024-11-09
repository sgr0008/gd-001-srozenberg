package com.documentor.backend.domain.dto;

import com.documentor.backend.casodeuso.service.usuario.UsuarioService;
import com.documentor.backend.infrastructure.repositories.DocumentoRepository;
import jakarta.validation.constraints.NotBlank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


    @SpringBootTest
    @ActiveProfiles("test")
    public  class DocumentationApplicationTests {

     @Autowired
     UsuarioService usuarioService;



        @Test
        public void findAllDocumento(){
           // Assertions.assertTrue(!usuarioService.findAll().isEmpty());
        }

}

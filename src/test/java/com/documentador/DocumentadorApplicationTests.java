package com.documentador;

import com.documentador.backend.repositories.DocumentoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
class DocumentadorApplicationTests {
 @Autowired
    DocumentoRepository documentoRepositoryrepo;
    @Test
    public void findAllDocumento(){
        assertTrue(documentoRepositoryrepo.findAll().isEmpty());
    }

}

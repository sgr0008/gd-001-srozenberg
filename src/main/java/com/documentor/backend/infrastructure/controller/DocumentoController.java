package com.documentor.backend.infrastructure.controller;


import com.documentor.backend.casodeuso.service.documento.DocumentoService;
import com.documentor.backend.domain.model.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/documento")
public class DocumentoController {

   @Autowired
   private DocumentoService documentoService;

  // insert a documento into database
   @PostMapping
   public ResponseEntity<Documento> saveProduct(@RequestBody Documento documento) {
       documento.setId(0L);
        Documento savedDocumento = documentoService.save(documento);
     return new ResponseEntity<>(savedDocumento, HttpStatus.CREATED);
   }


  //get a single documento by its id
   @GetMapping("/{id}")
   public ResponseEntity<Documento> getDocumento(@RequestParam(name = "id") long id) {
       Optional<Documento> documento = documentoService.findById(id);
       return new ResponseEntity<Documento>(documento.orElse(null), HttpStatus.OK);
   }


   //get all the Documento in the table in our database
   @GetMapping("/documentos")
   public List<Documento> getDocumentos() {
       return documentoService.findAll();
   }


   //update an existing documento in the database
   @PatchMapping
   public ResponseEntity<Documento> updateProduct(@RequestParam(name ="id") long id, @RequestBody Documento documento) {
       Documento updatedDocumento = documentoService.updateDocumento(id, documento);
       return new ResponseEntity<>(updatedDocumento, HttpStatus.ACCEPTED);
   }


   // delete an existing documento in the database
   @DeleteMapping("/{id}")
   public ResponseEntity<Documento> deleteProduct(@RequestParam(name ="id") long id) {
       Documento deletedDocumento =documentoService.findById(id).orElse(null);
       documentoService.deleteById(id);
       return new ResponseEntity<>(deletedDocumento, HttpStatus.OK);
   }

  
}
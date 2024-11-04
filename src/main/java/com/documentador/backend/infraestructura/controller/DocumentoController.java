package com.documentador.backend.infraestructura.controller;


import com.documentador.backend.casodeuso.service.documento.DocumentoService;
import com.documentador.backend.dominio.model.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
   @PostMapping("/saveDocumento")
   public ResponseEntity<Documento> saveProduct(@RequestBody Documento documento) {
        Documento savedDocumento = documentoService.save(documento);
     return new ResponseEntity<>(savedDocumento, HttpStatus.CREATED);
   }


  //get a single documento by its id
   @GetMapping("/documentoById")
   public ResponseEntity<Documento> getDocumento(@RequestParam(name = "id") long documentoId) {
       Optional<Documento> documento = documentoService.findById(documentoId);
       return new ResponseEntity<Documento>(documento.orElse(null), HttpStatus.OK);
   }


   //get all the Documento in the table in our database
   @GetMapping("/AllDocumento")
   public List<Documento> getDocumentos() {
       return documentoService.findAll();
   }


   //update an existing documento in the database
   @PatchMapping("/documentoUpdate")
   public ResponseEntity<Documento> updateProduct(@RequestParam(name ="id") long id, @RequestBody Documento documento) {
       Documento updatedDocumento = documentoService.updateDocumento(id, documento);
       return new ResponseEntity<>(updatedDocumento, HttpStatus.OK);
   }


   // delete an existing documento in the database
   @DeleteMapping("/documentoDeleteByID")
   public ResponseEntity<Documento> deleteProduct(@RequestParam(name ="id") long id) {
       Documento deletedDocumento =documentoService.findById(id).orElse(null);
       documentoService.deleteById(id);
       return new ResponseEntity<>(deletedDocumento, HttpStatus.OK);
   }

  
}
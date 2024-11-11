package com.backend.infrastructure.controller;


import com.backend.business.service.document.DocumentService;
import com.backend.domain.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/document")
public class DocumentController {

   @Autowired
   private DocumentService documentService;

  // insert a document into database
   @PostMapping
   public ResponseEntity<Document> saveProduct(@RequestBody Document document) {
       document.setId(0L);
        Document saveddocument = documentService.save(document);
     return new ResponseEntity<>(saveddocument, HttpStatus.CREATED);
   }


  //get a single document by its id
   @GetMapping("/{id}")
   public ResponseEntity<Document> getdocument(@RequestParam(name = "id") long id) {
       Optional<Document> document = documentService.findById(id);
       return new ResponseEntity<Document>(document.orElse(null), HttpStatus.OK);
   }


   //get all the document in the table in our database
   @GetMapping("/documents")
   public List<Document> getdocuments() {
       return documentService.findAll();
   }


   //update an existing document in the database
   @PatchMapping
   public ResponseEntity<Document> updateProduct(@RequestParam(name ="id") long id, @RequestBody Document document) {
       Document updateddocument = documentService.updatedocument(id, document);
       return new ResponseEntity<>(updateddocument, HttpStatus.ACCEPTED);
   }


   // delete an existing document in the database
   @DeleteMapping("/{id}")
   public ResponseEntity<Document> deleteProduct(@RequestParam(name ="id") long id) {
       Document deleteddocument =documentService.findById(id).orElse(null);
       documentService.deleteById(id);
       return new ResponseEntity<>(deleteddocument, HttpStatus.OK);
   }

  
}
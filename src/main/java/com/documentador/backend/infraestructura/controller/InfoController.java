package com.documentador.backend.infraestructura.controller;


import com.documentador.backend.casodeuso.service.Info.InfoService;
import com.documentador.backend.dominio.model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/info")
public class InfoController {


   @Autowired
   private InfoService infoService;


  // insert a info into database
   @PostMapping("/savedUsuario")
   public ResponseEntity<Info> saveProduct(@RequestBody Info info) {
    Info savedinfo = infoService.save(info);
     return new ResponseEntity<>(info, HttpStatus.CREATED);
   }


  //get a single info by its id
   @GetMapping("/usuarioById")
   public ResponseEntity<Info> getUsuario(@RequestParam(name = "id") long usuarioId) {
       Optional<Info> info = infoService.findById(usuarioId);
       return new ResponseEntity<Info>(info.orElse(null), HttpStatus.OK);
   }


   //get all the products in the table in our database
   @GetMapping("/AllInfos")
   public List<Info> getUsuarios() {
       return infoService.findAll();
   }


   //update an existing info in the database
   @PatchMapping("/usuarioUpdate")
   public ResponseEntity<Info> updateProduct(@RequestParam(name ="id") long id, @RequestBody Info info) {
       Info updatedInfo = infoService.updateInfo(id, info);
       return new ResponseEntity<>(updatedInfo, HttpStatus.OK);
   }


   // delete an existing info in the database
   @DeleteMapping("/usuarioDeleteByID")
   public ResponseEntity<Info> deleteProduct(@RequestParam(name ="id") long id) {
       Info deletedProduct =infoService.findById(id).orElse(null);
       infoService.deleteById(id);
       return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
   }

  
}
package com.documentor.backend.infrastructure.controller;


import com.documentor.backend.casodeuso.service.Info.InfoService;
import com.documentor.backend.domain.model.Info;
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
   @PostMapping("/saveInfo")
   public ResponseEntity<Info> saveInfo(@RequestBody Info info) {
        Info savedinfo = infoService.save(info);
     return new ResponseEntity<>(savedinfo, HttpStatus.CREATED);
   }


  //get a single info by its id
   @GetMapping("/infoById")
   public ResponseEntity<Info> getInfo(@RequestParam(name = "id") long infoId) {
            Optional<Info> info = infoService.findById(infoId);
       return new ResponseEntity<Info>(info.orElse(null), HttpStatus.OK);
   }


   //get all the products in the table in our database
   @GetMapping("/AllInfos")
   public List<Info> getUsuarios() {
       return infoService.findAll();
   }


   //update an existing info in the database
   @PatchMapping("/infoUpdate")
   public ResponseEntity<Info> updateProduct(@RequestParam(name ="id") long id, @RequestBody Info info) {
       Info updatedInfo = infoService.updateInfo(id, info);
       return new ResponseEntity<>(updatedInfo, HttpStatus.OK);
   }


   // delete an existing info in the database
   @DeleteMapping("/infoDeleteByID")
   public ResponseEntity<Info> deleteProduct(@RequestParam(name ="id") long id) {
       Info deletedInfo =infoService.findById(id).orElse(null);
       infoService.deleteById(id);
       return new ResponseEntity<>(deletedInfo, HttpStatus.OK);
   }

  
}
package com.documentor.backend.infrastructure.controller;



import com.documentor.backend.casodeuso.service.usuario.UsuarioService;
import com.documentor.backend.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/usuario/")
public class UsuarioController {


   @Autowired
   private UsuarioService usuarioService;


  // insert a usuario into database
   @PostMapping
   public ResponseEntity<Usuario> saveProduct(@RequestBody Usuario usuario) {
        usuario.setId(0L);
       Usuario savedUsuario = usuarioService.save(usuario);
     return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
   }

  //get a single usuario by its id
   @GetMapping("findById/{id}")
   public ResponseEntity<Usuario> getUsuario(@RequestParam(name = "id") long id) {
       Optional<Usuario> usuario = usuarioService.findById(id);
       return new ResponseEntity<Usuario>(usuario.orElse(null), HttpStatus.OK);
   }


   //get all the products in the table in our database
   @GetMapping("usuarios")
   public List<Usuario> getUsuarios() {
       return usuarioService.findAll();
   }


   //update an existing usuario in the database
   @PatchMapping("{id}")
   public ResponseEntity<Usuario> updateProduct(@RequestParam(name ="id") long id, @RequestBody Usuario usuario) {
       Usuario updatedProduct = usuarioService.updateUsuario(id, usuario);
       return new ResponseEntity<>(updatedProduct, HttpStatus.ACCEPTED);
   }


   // delete an existing usuario in the database
   @DeleteMapping("borrar/{id}")
   public ResponseEntity<Usuario> deleteProduct(@RequestParam(name ="id") long id) {
       Usuario deletedUsuario =usuarioService.findById(id).orElse(null);
       usuarioService.deleteById(id);
       return new ResponseEntity<>(deletedUsuario, HttpStatus.OK);
   }

  
}
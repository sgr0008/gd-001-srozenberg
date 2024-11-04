package com.documentador.backend.infraestructura.controller;



import com.documentador.backend.casodeuso.service.usuario.UsuarioService;
import com.documentador.backend.dominio.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/usuario")
public class UsuarioController {


   @Autowired
   private UsuarioService usuarioService;


  // insert a usuario into database
   @PostMapping("/savedUsuario")
   public ResponseEntity<Usuario> saveProduct(@RequestBody Usuario usuario) {
    Usuario savedUsuario = usuarioService.save(usuario);
     return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
   }


  //get a single usuario by its id
   @GetMapping("/usuarioById")
   public ResponseEntity<Usuario> getUsuario(@RequestParam(name = "id") long usuarioId) {
       Optional<Usuario> usuario = usuarioService.findById(usuarioId);
       return new ResponseEntity<Usuario>(usuario.orElse(null), HttpStatus.OK);
   }


   //get all the products in the table in our database
   @GetMapping("/AllUsuarios")
   public List<Usuario> getUsuarios() {
       return usuarioService.findAll();
   }


   //update an existing usuario in the database
   @PatchMapping("/usuarioUpdate")
   public ResponseEntity<Usuario> updateProduct(@RequestParam(name ="id") long id, @RequestBody Usuario usuario) {
       Usuario updatedProduct = usuarioService.updateUsuario(id, usuario);
       return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
   }


   // delete an existing usuario in the database
   @DeleteMapping("/usuarioDeleteByID")
   public ResponseEntity<Usuario> deleteProduct(@RequestParam(name ="id") long id) {
       Usuario deletedUsuario =usuarioService.findById(id).orElse(null);
       usuarioService.deleteById(id);
       return new ResponseEntity<>(deletedUsuario, HttpStatus.OK);
   }

  
}
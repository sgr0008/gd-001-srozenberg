package com.documentor.backend.infrastructure.controller;


import com.documentor.backend.business.service.usuario.UsuarioService;
import com.documentor.backend.domain.model.Usuario;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
  @ApiOperation(value = "Alta de Usuario", notes =  "Alta de Usuario")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
          @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
          @ApiResponse(code = 500, message = "Error interno de servidor")})
  @PostMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
  )
   public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        usuario.setId(0L);
       Usuario savedUsuario = usuarioService.save(usuario);
     return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
   }

  //get a single usuario by its id
  @ApiOperation(value = "Buscar de Usuario por Id ", notes =  "Buscar de Usuario por Id")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
          @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
          @ApiResponse(code = 500, message = "Error interno de servidor")})
  @GetMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
  )
   public ResponseEntity<Usuario> getUsuario(@RequestParam(name = "id") long id) {
       Optional<Usuario> usuario = usuarioService.findById(id);
       return new ResponseEntity<Usuario>(usuario.orElse(null), HttpStatus.OK);
   }

   //get all the products in the table in our database
   @ApiOperation(value = "Buscar de los Usuarios . ", notes =  "Buscar todos los usuarios")
   @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
           @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
           @ApiResponse(code = 500, message = "Error interno de servidor")})
   @GetMapping(path = "usuarios", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
   )
   public List<Usuario> getUsuarios() {
       return usuarioService.findAll();
   }

   //update an existing usuario in the database
   @ApiOperation(value = "Actualizar usuario por Id . ", notes =  "Actualizar usuario por Id . ")
   @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
           @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
           @ApiResponse(code = 500, message = "Error interno de servidor")})
   @PatchMapping( path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
   public ResponseEntity<Usuario> updateUsuario(@RequestParam(name ="id") long id, @RequestBody Usuario usuario) {
       usuario.setId(id);
       usuarioService.updateUsuario(id,usuario);
       return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);
   }


   // delete an existing usuario in the database
   @ApiOperation(value = "Borrar  usuario por Id . ", notes =  "Borrar usuario por Id . ")
   @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
           @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
           @ApiResponse(code = 500, message = "Error interno de servidor")})
   @DeleteMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
   )

   public ResponseEntity<Usuario> deleteProduct(@RequestParam(name ="id") long id) {
       Usuario deletedUsuario =usuarioService.findById(id).orElse(null);
       usuarioService.deleteById(id);
       return new ResponseEntity<>(deletedUsuario, HttpStatus.OK);
   }

  
}
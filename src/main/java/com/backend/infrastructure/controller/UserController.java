package com.backend.infrastructure.controller;


import com.backend.business.service.user.UserService;
import com.backend.domain.model.User;
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
@RequestMapping("api/user/")
public class UserController {

   @Autowired
   private UserService userService;

  // insert a user into database
  @ApiOperation(value = "Alta de user", notes =  "Alta de user")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
          @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
          @ApiResponse(code = 500, message = "Error interno de servidor")})
  @PostMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
  )
   public ResponseEntity<User> saveuser(@RequestBody User user) {
        user.setId(0L);
       User saveduser = userService.save(user);
     return new ResponseEntity<>(saveduser, HttpStatus.CREATED);
   }

  //get a single user by its id
  @ApiOperation(value = "Buscar de user por Id ", notes =  "Buscar de user por Id")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
          @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
          @ApiResponse(code = 500, message = "Error interno de servidor")})
  @GetMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
  )
   public ResponseEntity<User> getuser(@RequestParam(name = "id") long id) {
       Optional<User> user = userService.findById(id);
       return new ResponseEntity<User>(user.orElse(null), HttpStatus.OK);
   }

   //get all the products in the table in our database
   @ApiOperation(value = "Buscar de los users . ", notes =  "Buscar todos los users")
   @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
           @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
           @ApiResponse(code = 500, message = "Error interno de servidor")})
   @GetMapping(path = "users", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
   )
   public List<User> getusers() {
       return userService.findAll();
   }

   //update an existing user in the database
   @ApiOperation(value = "Actualizar user por Id . ", notes =  "Actualizar user por Id . ")
   @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
           @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
           @ApiResponse(code = 500, message = "Error interno de servidor")})
   @PatchMapping( path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
   public ResponseEntity<User> updateuser(@RequestParam(name ="id") long id, @RequestBody User user) {
       user.setId(id);
       userService.updateuser(id,user);
       return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
   }


   // delete an existing user in the database
   @ApiOperation(value = "Borrar  user por Id . ", notes =  "Borrar user por Id . ")
   @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
           @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
           @ApiResponse(code = 500, message = "Error interno de servidor")})
   @DeleteMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
   )

   public ResponseEntity<User> deleteUser(@RequestParam(name ="id") long id) {
       User deleteduser =userService.findById(id).orElse(null);
       userService.deleteById(id);
       return new ResponseEntity<>(deleteduser, HttpStatus.OK);
   }

  
}
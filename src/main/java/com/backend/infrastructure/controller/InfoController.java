package com.backend.infrastructure.controller;


import com.backend.business.service.Info.InfoService;
import com.backend.domain.model.Info;
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
@RequestMapping("api/info/")
public class InfoController {

    @Autowired
    private InfoService infoService;

    // insert a info into database
    @ApiOperation(value = "Alta de info", notes =  "Alta de info")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @PostMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<Info> saveInfo(@RequestBody Info info) {
        info.setId(0L);
        Info savedInfo = infoService.save(info);
        return new ResponseEntity<>(savedInfo, HttpStatus.CREATED);
    }
    //get a single info by its id
    @ApiOperation(value = "Buscar de info por Id ", notes =  "Buscar de info por Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @GetMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<Info> getInfo(@RequestParam(name = "id") long id) {
        Optional<Info> info = infoService.findById(id);
        return new ResponseEntity<Info>(info.orElse(null), HttpStatus.OK);
    }

    //get all the Info in the table in our database
    @ApiOperation(value = "Buscar de toda la INFO . ", notes =  "Buscar toda la Info")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @GetMapping(path = "infos", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public List<Info> getInfos() {
        return infoService.findAll();
    }

    //update an existing info in the database
    @ApiOperation(value = "Actualizar info por Id . ", notes =  "Actualizar info por Id . ")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @PatchMapping( path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
    public ResponseEntity<Info> updateInfo(@RequestParam(name ="id") long id, @RequestBody Info info) {
        info.setId(id);
        infoService.updateInfo(id,info);
        return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
    }


    // delete an existing info in the database
    @ApiOperation(value = "Borrar  info por Id . ", notes =  "Borrar info por Id . ")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @DeleteMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )

    public ResponseEntity<Info> deleteInfo(@RequestParam(name ="id") long id) {
        Info deleteduser =infoService.findById(id).orElse(null);
        infoService.deleteById(id);
        return new ResponseEntity<>(deleteduser, HttpStatus.OK);
    }


}
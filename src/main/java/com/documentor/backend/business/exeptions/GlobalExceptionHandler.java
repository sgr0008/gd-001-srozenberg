package com.documentor.backend.business.exeptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsuarioNombreAlreadyExistsException.class)
    public ResponseEntity<ResponseException> usernameAlreadyExistsException(UsuarioNombreAlreadyExistsException exception) {
        ResponseException apiResponseException = new ResponseException(exception.getMessage(), exception.getCode(), exception.getHttp());
        return ResponseEntity.status(exception.getHttp()).body(apiResponseException);
    }

    @ExceptionHandler(NotFoundUserExeptions.class)
    public ResponseEntity<ResponseException> notFoundProductExeptionsException(NotFoundUserExeptions usuarioExeptions) {
        ResponseException apiResponseException = new ResponseException(usuarioExeptions.getMessage(), usuarioExeptions.getCode(), usuarioExeptions.getHttp());
        return ResponseEntity.status(usuarioExeptions.getHttp()).body(apiResponseException);
    }

    public ResponseEntity<ResponseException> invalidProductEx(UsuarioInvalidoException exeptions){
        ResponseException apiResponseException = new ResponseException(exeptions.getMessage(), exeptions.getCode(), exeptions.getHttp());
        return ResponseEntity.status(exeptions.getHttp()).body(apiResponseException);
    }
}

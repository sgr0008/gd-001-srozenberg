package com.backend.business.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNombreAlreadyExistsException extends RuntimeException {
    private String message;
    private int code;
    private HttpStatus http;

    public UserNombreAlreadyExistsException() {
    }

    public UserNombreAlreadyExistsException(String message, int code, HttpStatus http) {
        this.message = message;
        this.code = code;
        this.http = http;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HttpStatus getHttp() {
        return http;
    }

    public void setHttp(HttpStatus http) {
        this.http = http;
    }
}

package com.backend.service;

import com.backend.domain.enums.StateDocumentEnum;
import com.backend.domain.enums.TypeDocumentEnum;
import com.backend.domain.model.Info;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentDto {

    private String tituloPrincipal;
    private String nombre;
    private TypeDocumentEnum tipodocument;
    private Info contenido;
    private UserDto user;
    private StateDocumentEnum estado;
    //Fecha int yyyyMMDDDhhmmss
    private int fechaUltimoCambio;
    private int fechaCreacion;
}

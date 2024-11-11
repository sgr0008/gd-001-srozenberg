package com.backend.service;

import lombok.Builder;
import lombok.Data;

/***
 * DTTO del Contexto o informacion de un document
 */
@Data
@Builder
public class InfoDto {

    private String nombre;
    private String descripcion;
    private String info;
    private int fechaUltimoCambio;

}
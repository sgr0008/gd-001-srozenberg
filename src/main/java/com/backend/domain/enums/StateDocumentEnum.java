package com.backend.domain.enums;

/**
 * Estado particular del document de un grupo.
 */
public enum StateDocumentEnum {

    VALIDO("document ACTUAL VALIDO",0),
    DEPRECADO("document INVALIDO",1),
    PENDIENTE("document pendiente a VALIDAR",2),
    ABIERTO("document en DESAARROLLO",3);

    private final String descripcion;
    private final int codigo;

    StateDocumentEnum(String descripcion, int codigo){
        this.descripcion = descripcion;
        this.codigo = codigo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public int getCodigo() {
        return codigo;
    }
}

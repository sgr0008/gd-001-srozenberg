package com.documentador.dominio.enums;

public enum EstadoDocumentoEnum {

    VALIDO("Documento ACTUAL VALIDO",0),
    DEPRECADO("Documento INVALIDO",1),
    PENDIENTE("Documento pendiente a VALIDAR",2),
    ABIERTO("Documento en DESAARROLLO",3);

    private final String descripcion;
    private final int codigo;

    EstadoDocumentoEnum(String descripcion, int codigo){
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

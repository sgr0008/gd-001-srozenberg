package com.documentador.backend.dominio.enums;
/**
 * Tipo o clasificacion particular del documento de un grupo.
 */
public enum TipoDocumentoEnum {

    INFO("Documento Informativo",0),
    ERROR("Documento que dessribe Error",1),
    SOLUCION("Documento que dessribe SOLUCION",2),
    PRUEBA("Documento que dessribe PRUEBA",3);

    private final String descripcion;
    private final int codigo;

    TipoDocumentoEnum(String descripcion, int codigo){
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

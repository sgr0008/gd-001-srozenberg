package com.backend.domain.enums;
/**
 * Tipo o clasificacion particular del document de un grupo.
 */
public enum TypeDocumentEnum {

    INFO("document Informativo",0),
    ERROR("document que dessribe Error",1),
    SOLUCION("document que dessribe SOLUCION",2),
    PRUEBA("document que dessribe PRUEBA",3);

    private final String descripcion;
    private final int codigo;

    TypeDocumentEnum(String descripcion, int codigo){
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

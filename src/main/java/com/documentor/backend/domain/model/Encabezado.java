package com.documentor.backend.domain.model;

/***
 * Encabezado general de un grupo de documentos
 */
public abstract class Encabezado {

private String tituloPrincipal;
private int fechaCreacion;

    public String getTituloPrincipal() {
        return tituloPrincipal;
    }

    public void setTituloPrincipal(String tituloPrincipal) {
        this.tituloPrincipal = tituloPrincipal;
    }

    public int getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(int fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}

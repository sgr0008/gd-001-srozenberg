package com.backend.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * Contexto o informacion de cada document
 * que integra un grupo
 */
@Entity
@Table(name = "info")
@Getter
@Setter
@NoArgsConstructor
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    @Column(columnDefinition = "TEXT")
    private String info;
    //TODO PAAR A DOC. Trato la fecha como int Fecha  formato yyyyMMDDDhhmmss ; para ordenar , mas facil
    @Column
    private int fechaUltimoCambio;

    public Info(long id, String info_test1,String descripcion, int fechaUltimoCambio) {
        this.id=id;
        this.setNombre(info_test1);
        this.setNombre(descripcion);
        this.fechaUltimoCambio=fechaUltimoCambio;
    }
}
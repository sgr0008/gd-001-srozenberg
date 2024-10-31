package com.desa.documentador.dominio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    //TODO PASAR A DOC. Trato la fecha como int Fecha  formato yyyyMMDDDhhmmss ; para ordenar , mas facil
    @Column
    private int fechaUltimoCambio;

}
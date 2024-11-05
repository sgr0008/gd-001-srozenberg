package com.documentor.backend.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "usuario")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column (unique = false)
    private int fechaCreacion;

    public Usuario(Long id, String descrip, int fecha) {
        this.id=id;
        this.name=descrip;
        this.fechaCreacion=fecha;
    }
}

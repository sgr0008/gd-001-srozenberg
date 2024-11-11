package com.backend.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column (unique = false)
    private int fechaCreacion;

    public User(Long id, String descrip, int fecha) {
        this.id=id;
        this.name=descrip;
        this.fechaCreacion=fecha;
    }


}

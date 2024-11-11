package com.backend.domain.model;

import com.backend.domain.enums.StateDocumentEnum;
import com.backend.domain.enums.TypeDocumentEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * Informacion del document
 */
@Table(name = "document")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Document  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String tituloPrincipal;
    @Column
    private String nombre;
    @Column
    private TypeDocumentEnum documentTypeEnum;
    @OneToOne
    @JoinColumn(name = "contenido_id")
    private Info contenido;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private StateDocumentEnum estado;
    //Fecha int yyyyMMDDDhhmmss  para facilitar ordenamiento
    @Column
    private int fechaUltimoCambio;
    @Column
    private int fechaCreacion;



}
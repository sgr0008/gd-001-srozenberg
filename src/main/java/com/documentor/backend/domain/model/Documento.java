package com.documentor.backend.domain.model;

import com.documentor.backend.domain.enums.EstadoDocumentoEnum;
import com.documentor.backend.domain.enums.TipoDocumentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * Informacion del Documento
 */
@Table(name = "documento")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Documento  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String tituloPrincipal;
    @Column
    private String nombre;
    @Column
    private TipoDocumentoEnum tipoDocumento;
    @OneToOne
    @JoinColumn(name = "contenido_id")
    private Info contenido;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @Column
    private EstadoDocumentoEnum estado;
    //Fecha int yyyyMMDDDhhmmss  para facilitar ordenamiento
    @Column
    private int fechaUltimoCambio;
    @Column
    private int fechaCreacion;



}
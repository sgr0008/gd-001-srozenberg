package com.desa.documentador.dominio.model;

import com.desa.documentador.dominio.enums.EstadoDocumentoEnum;
import com.desa.documentador.dominio.enums.TipoDocumentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "documento")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private int fechaCreacion;
    @Column
    private EstadoDocumentoEnum estado;
    //Fecha iny yyyyMMDDDhhmmss
    @Column
    private int fechaUltimoCambio;



}
package com.documentador.dominio.model;

import com.documentador.dominio.enums.EstadoDocumentoEnum;
import com.documentador.dominio.enums.TipoDocumentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * Informacion¿ de los documentos de un grupo
 */
@Table(name = "documento")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Documento extends Encabezado {

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
    private EstadoDocumentoEnum estado;
    //Fecha iny yyyyMMDDDhhmmss
    @Column
    private int fechaUltimoCambio;



}
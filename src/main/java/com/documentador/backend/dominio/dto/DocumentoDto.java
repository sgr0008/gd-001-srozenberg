package com.documentador.backend.dominio.dto;

import com.documentador.backend.dominio.enums.EstadoDocumentoEnum;
import com.documentador.backend.dominio.enums.TipoDocumentoEnum;
import com.documentador.backend.dominio.model.Info;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DocumentoDto {
    private String tituloPrincipal;
    private int fechaCreacion;
    private String nombre;
    private TipoDocumentoEnum tipoDocumento;
    private Info contenido;
    private UsuarioDto usuario;
    private EstadoDocumentoEnum estado;
    //Fecha int yyyyMMDDDhhmmss
    private int fechaUltimoCambio;
}

package com.documentor.backend.domain.dto;

import com.documentor.backend.domain.enums.EstadoDocumentoEnum;
import com.documentor.backend.domain.enums.TipoDocumentoEnum;
import com.documentor.backend.domain.model.Info;
import lombok.*;

@Data
@Builder
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

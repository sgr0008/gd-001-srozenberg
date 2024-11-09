package com.documentor.backend.domain.mapper;

import com.documentor.backend.domain.dto.UsuarioDto;
import com.documentor.backend.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper( UsuarioMapper.class );

    @Mapping(source = "id", target = "id")
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    @Mapping(source = "id", target = "id")
    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);
}

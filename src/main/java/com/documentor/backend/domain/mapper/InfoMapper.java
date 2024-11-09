package com.documentor.backend.domain.mapper;

import com.documentor.backend.domain.dto.InfoDto;
import com.documentor.backend.domain.dto.UsuarioDto;
import com.documentor.backend.domain.model.Info;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface InfoMapper {

    InfoMapper INSTANCE = Mappers.getMapper( InfoMapper.class );

    @Mapping(source = "id", target = "id")
    InfoDto usuarioToinfoDto(Info info);
    @Mapping(source = "id", target = "id")
    Info infoDtoToInfo(UsuarioDto usuarioDto);
}

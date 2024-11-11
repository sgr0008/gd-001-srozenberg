package com.backend.domain.mapper;

import com.backend.domain.model.Info;
import com.backend.service.InfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface InfoMapper {

    InfoMapper INSTANCE = Mappers.getMapper( InfoMapper.class );

    @Mapping(source = "id", target = "id")
    InfoDto infoToinfoDto(Info info);
    @Mapping(source = "id", target = "id")
    Info infoDtoToInfo(InfoDto infoDto);
}

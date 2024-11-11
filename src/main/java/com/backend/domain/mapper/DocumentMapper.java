package com.backend.domain.mapper;

import com.backend.domain.model.Document;
import com.backend.service.DocumentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface DocumentMapper {

    DocumentMapper INSTANCE = Mappers.getMapper( DocumentMapper.class );

    @Mapping(source = "id", target = "id")
    DocumentDto docunetToDocumentDto(Document document);
    @Mapping(source = "id", target = "id")
    Document documentDtoToDocument(DocumentDto documentDto);
}

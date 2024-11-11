package com.backend.domain.mapper;

import com.backend.service.UserDto;
import com.backend.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(source = "id", target = "id")
    UserDto userTouserDto(User user);
    @Mapping(source = "id", target = "id")
    User userDtoTouser(UserDto userDto);
}

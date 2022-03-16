package com.moviebook.dto.mapper;

import com.moviebook.dto.UserDto;
import com.moviebook.entities.Film;
import com.moviebook.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);
    // SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );
    //UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserDto toDto(User entity);
    User toEntity(UserDto dto);
}

package com.moviebook.dto.mapper;

import com.moviebook.dto.UserDto;
import com.moviebook.entities.Film;
import com.moviebook.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto mapperEntityToUserDto(User entity) {
        var dto = new UserDto();
        BeanUtils.copyProperties(entity, dto, "film.owner");

        return dto;
    }

    public User mapperDtoToFilmEntity(UserDto dto) {
        var entity = new User();

        BeanUtils.copyProperties(dto, entity);

        return entity;
    }
}

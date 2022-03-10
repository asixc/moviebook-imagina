package com.moviebook.dto.mapper;

import com.moviebook.dto.FilmDto;
import com.moviebook.entities.User;
import com.moviebook.entities.Film;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

    public FilmDto mapperEntityToFilmDto(Film entity) {
        var dto = new FilmDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setOwner(entity.getOwner().getEmail());
        return dto;
    }

    public Film mapperDtoToFilmEntity(FilmDto dto) {
        var entity = new Film();
        var user = new User();

        String[] ignoreProperties= new String[]{"owner","owner.email"};
        BeanUtils.copyProperties(dto, entity);

        user.setEmail(dto.getOwner());
        entity.setOwner(user);
        return entity;
    }
}

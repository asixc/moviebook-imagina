package com.moviebook.service.impl;

import com.moviebook.entities.Director;
import com.moviebook.repository.DirectorRepository;
import com.moviebook.service.DirectorQueryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorQueryServiceImpl implements DirectorQueryService {

    private static final Log log = LogFactory.getLog(DirectorQueryServiceImpl.class);

    private final DirectorRepository directorRepository;

    public DirectorQueryServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public Director insertDirector(Director director) {
        this.directorRepository.insertDirector(director.getFirstName(), director.getLastName());
        return this.directorRepository.findByFirstNameAndLastName(director.getFirstName(), director.getLastName());
    }

    @Override
    public void deleteDirector(Director director) {

    }

    @Override
    public Director updatetDirector(Director director) {
        return null;
    }

    @Override
    public List<Director> findAll() {
        return this.directorRepository.findAll();
    }


}

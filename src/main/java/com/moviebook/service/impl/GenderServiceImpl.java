package com.moviebook.service.impl;

import com.moviebook.entities.Gender;
import com.moviebook.repository.GenderRepository;
import com.moviebook.service.GenderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {

    private static final Log log = LogFactory.getLog(GenderServiceImpl.class);

    private final GenderRepository genderRepository;

    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public Optional<Gender> findById(String id) {
        log.info("GenderServiceImpl FindById:" + id);
        return this.genderRepository.findById(id);
    }

    @Override
    public Gender save(Gender gender) {
        return this.genderRepository.save(gender);
    }

    @Override
    public List<Gender> saveAll(List<Gender> genders) {
        return this.genderRepository.saveAll(genders);
    }

    @Override
    public void deleteById(String id) {
        this.genderRepository.deleteById(id);
    }

    @Override
    public List<Gender> findAll() {
        return this.genderRepository.findAll();
    }

}

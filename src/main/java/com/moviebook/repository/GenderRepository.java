package com.moviebook.repository;

import com.moviebook.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository  extends JpaRepository<Gender, String> {
}

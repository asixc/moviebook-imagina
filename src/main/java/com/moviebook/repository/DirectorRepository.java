package com.moviebook.repository;

import com.moviebook.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    /* @Query
     * update
     * insert
     * delete
     */

    @Transactional
    @Modifying
    @Query(value = "delete from directors where id = :id", nativeQuery = true)
    void deleteDirectorCustomQuery(Long id);

    @Transactional
    @Modifying
    @Query(value = "update directors set first_name = :firstName , last_name = :lastName where id = :id ", nativeQuery = true)
    void updateDirector(String firstName, String lastName, Long id);

    @Transactional
    @Modifying
    @Query(value = """
            insert into directors (first_name, last_name)
            values (:firstName, :lastName);
                    """, nativeQuery = true)
    void insertDirector(String firstName, String lastName);

    Director findByFirstNameAndLastName(String firstName, String lastName);
}

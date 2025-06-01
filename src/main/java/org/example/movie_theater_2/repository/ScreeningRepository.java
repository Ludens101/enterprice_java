package org.example.movie_theater_2.repository;

import org.example.movie_theater_2.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}

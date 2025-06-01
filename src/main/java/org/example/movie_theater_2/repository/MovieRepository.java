package org.example.movie_theater_2.repository;

import org.example.movie_theater_2.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MovieRepository extends JpaRepository<Movie, Long> {
}

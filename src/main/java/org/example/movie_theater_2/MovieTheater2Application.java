package org.example.movie_theater_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.example.movie_theater_2.repository")
@EntityScan(basePackages = "org.example.movie_theater_2.model")
public class MovieTheater2Application {

    public static void main(String[] args) {
        SpringApplication.run(MovieTheater2Application.class, args);
    }

}

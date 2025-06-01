package org.example.movie_theater_2.repository;


import org.example.movie_theater_2.model.Role;
import org.example.movie_theater_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String role);
}

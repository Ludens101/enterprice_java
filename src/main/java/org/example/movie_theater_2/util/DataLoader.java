package org.example.movie_theater_2.util;

import org.example.movie_theater_2.model.Role;
import org.example.movie_theater_2.model.User;
import org.example.movie_theater_2.repository.RoleRepository;
import org.example.movie_theater_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role userRole = roleRepository.save(new Role( "ROLE_USER"));
        Role adminRole = roleRepository.save(new Role("ROLE_ADMIN"));

        User user = new User();
        user.setLogin("johndoe");
        user.setEmail("johndoe@gmail.com");
        user.setPassword("password");
        user.setEnabled(true);
        user.setRoles(Set.of(userRole));

        User admin = new User();
        admin.setLogin("admin");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("adminpassword");
        admin.setEnabled(true);
        admin.setRoles(Set.of(adminRole));

        userRepository.save(user);
        userRepository.save(admin);


    }


}

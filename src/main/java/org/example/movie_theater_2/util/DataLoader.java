package org.example.movie_theater_2.util;

import org.example.movie_theater_2.model.*;
import org.example.movie_theater_2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final MovieRepository movieRepository;
    private final ScreeningRepository screeningRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, RoleRepository roleRepository, MovieRepository movieRepository, ScreeningRepository screeningRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.movieRepository = movieRepository;
        this.screeningRepository = screeningRepository;
        this.ticketRepository = ticketRepository;
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

        Movie movie1 = movieRepository.save(new Movie("Inception", "Sci-Fi", 148, 13));
        Movie movie2 = movieRepository.save(new Movie("The Lion King", "Animation", 88, 0));

        Screening screening1 = screeningRepository.save(new Screening(movie1.getId(), LocalDateTime.now().plusDays(1), "Hall A"));
        Screening screening2 = screeningRepository.save(new Screening(movie2.getId(), LocalDateTime.now().plusDays(2), "Hall B"));

        ticketRepository.save(new Ticket(screening1.getId(), "John Doe", "A1"));
        ticketRepository.save(new Ticket(screening1.getId(), "Jane Doe", "A2"));
        ticketRepository.save(new Ticket(screening2.getId(), "Alice Smith", "B1"));
    }


}

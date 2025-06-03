package org.example.movie_theater_2.controller;



import org.example.movie_theater_2.model.Screening;
import org.example.movie_theater_2.repository.ScreeningRepository;
import org.example.movie_theater_2.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/screenings")
public class ScreeningController {

    private final ScreeningService screeningService;

    @Autowired
    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Screening>> getAllScreenings() {
        return ResponseEntity.ok(screeningService.getAllScreenings());
    }

    @GetMapping("/view")
    public String viewScreenings(Model model) {
        model.addAttribute("screenings", screeningService.getAllScreenings());
        return "screenings";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screening> getScreeningById(@PathVariable Long id) {
        Optional<Screening> screening = screeningService.getScreeningById(id);
        return screening.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Screening> addScreening(@RequestBody Screening screening) {
        Screening savedScreening = screeningService.addScreening(screening);
        return ResponseEntity.ok(savedScreening);
    }
}
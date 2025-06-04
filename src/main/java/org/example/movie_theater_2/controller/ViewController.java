package org.example.movie_theater_2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ViewController {

    private static final Logger logger = LoggerFactory.getLogger(ViewController.class.getName());

    @GetMapping("/login")
    public String login() {
        logger.debug("User accessed login page");
        return "login";
    }

    @GetMapping("/user/home")
    public String userHome() {
        logger.debug("User profile accessed");
        return "user";
    }

    @GetMapping("/admin/home")
    public String adminHome() {
        logger.debug("Admin profile accessed");
        return "admin";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        logger.warn("Access denied");
        return "access-denied";
    }

    @GetMapping("/default")
    public String defaultAfterLogin(Authentication auth) {
        if (auth.getAuthorities().stream().allMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin/home";
        }else if (auth.getAuthorities().stream().allMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
            return "redirect:/user/home";
        }

        return "redirect:/access-denied";
    }
}

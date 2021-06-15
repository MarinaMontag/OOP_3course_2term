package ua.knu.montag.backend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('STUDENT') or hasRole('TUTOR')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/student")
    @PreAuthorize("hasRole('STUDENT')")
    public String studentAccess() {
        return "Student Board.";
    }

    @GetMapping("/tutor")
    @PreAuthorize("hasRole('TUTOR')")
    public String tutorAccess() {
        return "Tutor Board.";
    }

}
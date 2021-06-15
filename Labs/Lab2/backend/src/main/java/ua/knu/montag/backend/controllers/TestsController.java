package ua.knu.montag.backend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.knu.montag.backend.payload.response.FullTestResponse;
import ua.knu.montag.backend.payload.response.TestsResponse;
import ua.knu.montag.backend.security.services.TestService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TestsController {
    private final TestService service;

    public TestsController(TestService service) {
        this.service = service;
    }

    @GetMapping("/subjects/{id}")
    public ResponseEntity<?> getSubjectTest(@PathVariable int id) {
        return ResponseEntity.ok(new TestsResponse(service.getTestsBySubjectId(id)));
    }

    @GetMapping("/test/{id}")
    @PreAuthorize("hasRole('STUDENT') or hasRole('TUTOR')")
    public ResponseEntity<?> getTest(@PathVariable long id) {
      return ResponseEntity.ok(service.getTestById(id));
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

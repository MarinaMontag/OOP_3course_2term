package ua.knu.montag.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.knu.montag.backend.payload.FullTest;
import ua.knu.montag.backend.payload.response.MessageResponse;
import ua.knu.montag.backend.payload.response.TestsResponse;
import ua.knu.montag.backend.security.services.TestService;

import javax.validation.Valid;

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

    @PostMapping("/test")
    @PreAuthorize("hasRole('TUTOR')")
    public ResponseEntity<?> addTest(@Valid @RequestBody FullTest test) {
        service.addTest(test);
        return ResponseEntity.ok().body(new MessageResponse("Test created successfully"));
    }

}

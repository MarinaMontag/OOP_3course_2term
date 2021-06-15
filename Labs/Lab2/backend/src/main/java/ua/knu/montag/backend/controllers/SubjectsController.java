package ua.knu.montag.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.knu.montag.backend.payload.response.SubjectResponse;
import ua.knu.montag.backend.security.services.SubjectService;
import ua.knu.montag.backend.security.services.SubjectServiceImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/subjects")
public class SubjectsController {
    private final SubjectService service;

    public SubjectsController(SubjectService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<?> getSubjects(){
        return ResponseEntity.ok(new SubjectResponse(service.getAllSubjects()));
    }
}

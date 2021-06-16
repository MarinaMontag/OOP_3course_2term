package ua.knu.montag.backend.security.services;

import ua.knu.montag.backend.models.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject>getAllSubjects();
    Subject getSubjectById(int id);
}

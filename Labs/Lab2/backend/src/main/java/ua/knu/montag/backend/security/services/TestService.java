package ua.knu.montag.backend.security.services;

import ua.knu.montag.backend.models.Test;
import ua.knu.montag.backend.payload.FullTest;

import java.util.List;

public interface TestService {
    List<Test>getTestsBySubjectId(int id);
    FullTest getTestById(long id);
    void addTest(FullTest test);
}

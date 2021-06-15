package ua.knu.montag.backend.security.services;

import ua.knu.montag.backend.models.Test;
import ua.knu.montag.backend.payload.response.FullTestResponse;

import java.util.List;

public interface TestService {
    List<Test>getTestsBySubjectId(int id);
    FullTestResponse getTestById(long id);
}

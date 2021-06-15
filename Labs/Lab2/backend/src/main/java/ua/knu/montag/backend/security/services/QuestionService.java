package ua.knu.montag.backend.security.services;

import ua.knu.montag.backend.models.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionsByTestId(long id);
}

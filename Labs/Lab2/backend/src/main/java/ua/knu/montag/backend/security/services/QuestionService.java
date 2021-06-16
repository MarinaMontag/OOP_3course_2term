package ua.knu.montag.backend.security.services;

import ua.knu.montag.backend.models.Question;
import ua.knu.montag.backend.models.Test;
import ua.knu.montag.backend.payload.TestQuestion;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionsByTestId(long id);
    void addQuestion(TestQuestion question, Test test);
    long getLastCreatedQuestionId();
    Question getQuestionById(long id);
}

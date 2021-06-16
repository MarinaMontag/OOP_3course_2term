package ua.knu.montag.backend.security.services;

import ua.knu.montag.backend.models.Answer;
import ua.knu.montag.backend.models.Question;
import ua.knu.montag.backend.payload.QuestionAnswer;

import java.util.List;

public interface AnswerService {
    List<Answer>getAnswersByQuestionId(long id);
    void addAnswer(QuestionAnswer answer, Question question);
}

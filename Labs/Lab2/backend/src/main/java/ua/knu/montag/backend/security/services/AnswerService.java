package ua.knu.montag.backend.security.services;

import ua.knu.montag.backend.models.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer>getAnswersByQuestionId(long id);
}

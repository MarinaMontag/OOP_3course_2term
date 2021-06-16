package ua.knu.montag.backend.security.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.knu.montag.backend.models.Answer;
import ua.knu.montag.backend.models.Question;
import ua.knu.montag.backend.payload.QuestionAnswer;
import ua.knu.montag.backend.repository.AnswerRepository;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService{
    private final AnswerRepository repository;

    public AnswerServiceImpl(AnswerRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<Answer> getAnswersByQuestionId(long id) {
        return repository.findAllByQuestionId(id);
    }

    @Override
    public void addAnswer(QuestionAnswer answer, Question question) {
        repository.save(new Answer(question, answer.getText(), answer.isCorrectness()));
    }
}

package ua.knu.montag.backend.security.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.knu.montag.backend.models.Question;
import ua.knu.montag.backend.models.Test;
import ua.knu.montag.backend.payload.TestQuestion;
import ua.knu.montag.backend.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    private final QuestionRepository repository;

    public QuestionServiceImpl(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<Question> getQuestionsByTestId(long id) {
        return repository.findAllByTestId(id);
    }

    @Override
    @Transactional
    public void addQuestion(TestQuestion question, Test test) {
        repository.save(new Question(test, question.getText()));
    }

    @Override
    @Transactional
    public long getLastCreatedQuestionId() {
        return repository.getLastCreatedQuestionId();
    }

    @Override
    @Transactional
    public Question getQuestionById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No question found by id: "+id));
    }
}

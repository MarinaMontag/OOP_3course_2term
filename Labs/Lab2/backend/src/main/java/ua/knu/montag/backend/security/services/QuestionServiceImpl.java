package ua.knu.montag.backend.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.knu.montag.backend.models.Question;
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
}

package ua.knu.montag.backend.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.knu.montag.backend.models.Answer;
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
}

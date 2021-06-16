package ua.knu.montag.backend.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.knu.montag.backend.models.Subject;
import ua.knu.montag.backend.repository.SubjectRepository;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository repository;
    @Override
    @Transactional
    public List<Subject> getAllSubjects() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Subject getSubjectById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No subject found by id: "+id));
    }
}

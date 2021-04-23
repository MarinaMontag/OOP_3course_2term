package service;

import exception.ServerException;
import model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubjects() throws ServerException;
}

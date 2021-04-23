package service;

import dao.SubjectDAO;
import exception.ServerException;
import model.Subject;

import java.util.List;

public class SubjectServiceImpl implements SubjectService{

    @Override
    public List<Subject> getSubjects() throws ServerException {
        return SubjectDAO.getAllSubjects();
    }
}

package service;

import dao.SubjectDAO;
import exception.ServerException;
import model.SubjectList;

import java.util.List;

public class SubjectServiceImpl implements SubjectService{

    @Override
    public SubjectList getSubjects() throws ServerException {
        return SubjectDAO.getAllSubjects();
    }
}

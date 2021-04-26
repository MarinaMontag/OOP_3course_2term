package service;

import dao.TestDAO;
import exception.ServerException;
import model.TestList;

public class TestServiceImpl implements TestService {
    @Override
    public TestList getTestsBySubjectId(int id) throws ServerException {
        return TestDAO.selectTestsBySubjectId(id);
    }
}

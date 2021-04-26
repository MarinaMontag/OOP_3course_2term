package service;

import exception.ServerException;
import model.TestList;

public interface TestService {
    TestList getTestsBySubjectId(int id) throws ServerException;
}

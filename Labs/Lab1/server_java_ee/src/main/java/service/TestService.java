package service;

import exception.ServerException;
import model.QuestionList;
import model.TestList;

public interface TestService {
    TestList getTestsBySubjectId(int id) throws ServerException;
    QuestionList getQuestionAndAnswersByTestId(int id)throws ServerException;
}

package service;

import dao.TestDAO;
import exception.ServerException;
import model.QuestionList;
import model.TestList;

public class TestServiceImpl implements TestService {
    @Override
    public TestList getTestsBySubjectId(int id) throws ServerException {
        return TestDAO.selectTestsBySubjectId(id);
    }
    @Override
    public QuestionList getQuestionAndAnswersByTestId(int id)throws ServerException{
        return TestDAO.selectQuestionsAndAnswersByTestId(id);
    }
}

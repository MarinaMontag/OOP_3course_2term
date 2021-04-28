package dao;

import exception.ServerException;
import model.*;
import util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
    private static final String selectTestsBySubjectIdQuery =
            "SELECT * FROM tests WHERE s_id = ?";
    private static final String selectQuestionsByTestIdQuery =
            "SELECT * FROM ques WHERE t_id = ?";
    private static final String selectAnswersByQuestionIdQuery =
            "SELECT * FROM answ WHERE q_id = ?";
    public static TestList selectTestsBySubjectId(int id) throws ServerException {
        List<Test> tests;
        try(Connection conn = JdbcConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(selectTestsBySubjectIdQuery);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            tests=new ArrayList<>();
            while (resultSet.next()){
                tests.add(new Test(resultSet.getInt(1),
                                    resultSet.getInt(2),
                                    resultSet.getString(3),
                                    resultSet.getString(4)));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServerException("can not select tests");
        }
        return new TestList(tests);
    }
    public static QuestionList selectQuestionsAndAnswersByTestId(int id) throws ServerException {
        List<Question>questions;
        try(Connection conn = JdbcConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuestionsByTestIdQuery);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            questions=new ArrayList<>();
            while (resultSet.next()){
                questions.add(new Question(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3)));
                List<Answer> answerList = selectAnswersByQuestionId(resultSet.getInt(1));
                questions.get(questions.size()-1).setAnswerList(answerList);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServerException("can not select tests");
        }
        return new QuestionList(questions);
    }
    private static List<Answer> selectAnswersByQuestionId(int id) throws ServerException {
        List<Answer>answers;
        try(Connection conn = JdbcConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(selectAnswersByQuestionIdQuery);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            answers=new ArrayList<>();
            while (resultSet.next()){
                answers.add(new Answer(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        getCorrectnessOfAnswer(resultSet.getInt(4))));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServerException("can not select answers");
        }
        return answers;
    }
    private static boolean getCorrectnessOfAnswer(int corr){
        return corr==1;
    }
}

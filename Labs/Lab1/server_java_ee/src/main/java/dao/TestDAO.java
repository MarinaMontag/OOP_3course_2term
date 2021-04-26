package dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.ServerException;
import model.Test;
import model.TestList;
import util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
    private static final String selectTestsBySubjectId =
            "SELECT t_id, tname, tdesc FROM tests WHERE s_id = ?";
    public static TestList selectTestsBySubjectId(int id) throws ServerException {
        List<Test> tests;
        try(Connection conn = JdbcConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(selectTestsBySubjectId);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            tests=new ArrayList<>();
            while (resultSet.next()){
                tests.add(new Test(resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getString(3)));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServerException("can not select tests");
        }
        return new TestList(tests);
    }
}

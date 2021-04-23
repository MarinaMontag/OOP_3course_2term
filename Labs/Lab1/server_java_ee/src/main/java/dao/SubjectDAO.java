package dao;

import exception.ServerException;
import model.Subject;
import util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {
    private static final String selectAllQuery =
            "SELECT * FROM subj";
    public static List<Subject> getAllSubjects() throws ServerException {
        List<Subject>subjects;
        try(Connection conn = JdbcConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(selectAllQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            subjects=new ArrayList<>();
            while (resultSet.next()){
                subjects.add(new Subject(resultSet.getInt(1), resultSet.getString(2)));
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new ServerException("can not select subjects");
        }
        return subjects;
    }
}

package dao;

import exception.ServerException;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.JdbcConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDAO {
    private static final String addUserQuery =
            "INSERT INTO users VALUES (default, ?, ?, ?, ?, ?)";
    public static User addUser(User user) throws ServerException, ClassNotFoundException {
        if(user==null)
            return null;
        try(Connection conn = JdbcConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(addUserQuery);
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setInt(5,user.getRole().ordinal());
            int rows = preparedStatement.executeUpdate();
            if(rows <= 0) {
                return null;
            }
        }catch (SQLException e){
            throw new ServerException("can not add new user");
        }
        return user;
    }
}

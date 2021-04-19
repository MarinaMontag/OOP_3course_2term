package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url ="jdbc:postgresql://127.0.0.1:5432/testing_system";
        String username = "postgres";
        String password ="modusnika";
        return DriverManager.getConnection(url, username, password);
    }

}

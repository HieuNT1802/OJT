package fa.training.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    public static Connection getConnection() throws SQLException {

        return  DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=SMS", "sa", "123456");
    }
}

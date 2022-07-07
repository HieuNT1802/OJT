package fa.training.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        //{protocol}:{vendor}:{database connection properties}
        Connection connection =
                DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=SMS",
                        "trunghieu1", "12345678");

        return connection;
    }
}

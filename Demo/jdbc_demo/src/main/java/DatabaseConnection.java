import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author <a href="mailto:phuongdp.tech@gmail.com">PhuongDP</a>
 */
public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        //{protocol}:{vendor}:{database connection properties}
        Connection connection =
                DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=cpl_java_05",
                        "trunghieu1", "12345678");

        return connection;
    }
}

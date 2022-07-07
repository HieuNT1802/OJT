import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.*;

public class DbContext {

        private static String dbPrefix = "jdbc:sqlserver://localhost";
        private static String user = "trunghieu1";
        private static String pass = "12345678";
        private static String dbPort = "1433";
        private static String databaseName = "cpl_java_05";

        public static Connection getConnection() {
            Connection conn = null;
            String dbURL = dbPrefix + ":" + dbPort + ";" + "databaseName=" + databaseName;
            try {
                DriverManager.registerDriver(new SQLServerDriver());
                conn = DriverManager.getConnection(dbURL, user, pass);
               System.out.println("connect successfully!");
            } catch (SQLException e) {
                System.out.println("connect failure!");
                e.printStackTrace();
            }
            return conn;
        }


}


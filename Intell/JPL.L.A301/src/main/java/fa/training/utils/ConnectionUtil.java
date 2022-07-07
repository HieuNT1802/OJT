package fa.training.utils;

import java.sql.*;

public class ConnectionUtil {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=SMS;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "142378956";
    private static PreparedStatement preparedStatement;
    private static CallableStatement callableStatement;
    public static ResultSet rs = null;
    public static boolean result = false;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private static PreparedStatement getStatement(String sql, Object... args) throws SQLException {
        preparedStatement = getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        return preparedStatement;
    }

    public static ResultSet executeQuery(String sql, Object... args) throws SQLException {
        preparedStatement = getStatement(sql, args);
        return preparedStatement.executeQuery();
    }

    public static boolean executeUpdate(String sql, Object... args) throws SQLException {
        preparedStatement = getStatement(sql, args);
        return preparedStatement.executeUpdate() > 0;
    }

    public static int executeUpdateForIdentity(String sql, Object... args) throws SQLException {
        String[] generatedColumns = {"id"};
        int id = 0;
        preparedStatement = getConnection().prepareStatement(sql, generatedColumns);
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        preparedStatement.executeUpdate();
        rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }
}
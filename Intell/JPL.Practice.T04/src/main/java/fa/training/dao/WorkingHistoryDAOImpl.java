package fa.training.dao;

import fa.training.entities.Working_History;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkingHistoryDAOImpl implements WorkingHistoryDAO{
    @Override
    public boolean save(Working_History workingHistory) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO Working_History VALUES ( ?,?,?,? )");
            statement.setInt(1, workingHistory.getDeptId());
            statement.setInt(2, workingHistory.getEmpId());
            statement.setDate(3, java.sql.Date.valueOf(workingHistory.getFromDate()));
            statement.setDate(4, java.sql.Date.valueOf(workingHistory.getToDate()));
            return statement.executeUpdate() > 0;
        }
    }
}

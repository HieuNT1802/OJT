package fa.training.dao;

import fa.training.entities.Working_History;

import java.sql.SQLException;

public interface WorkingHistoryDAO {
    boolean save(Working_History workingHistory) throws SQLException;
}

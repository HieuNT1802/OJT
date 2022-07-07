package fa.training.dao;

import fa.training.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentImpl implements DepartmentDAO{
    @Override
    public boolean save(Department department) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO Department VALUES ( ?, ? )");
           // statement.setInt(1, department.getDeptId());
            statement.setString(1, department.getDeptName());
            statement.setString(2, department.getDescription());
            return statement.executeUpdate() > 0;
        }
    }
}

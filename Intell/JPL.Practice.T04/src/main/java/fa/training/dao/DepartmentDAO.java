package fa.training.dao;

import fa.training.entities.Department;

import java.sql.SQLException;

public interface DepartmentDAO {
    boolean save(Department department) throws SQLException;

}

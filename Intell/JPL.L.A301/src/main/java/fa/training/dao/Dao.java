package fa.training.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    List<T> getAll() throws SQLException;

    List<T> getALlByID(int id) throws SQLException;

    boolean update(T t) throws SQLException;

    boolean delete(int id) throws SQLException;

    boolean checkExits(int id) throws SQLException;

    boolean add(T t) throws SQLException;
}

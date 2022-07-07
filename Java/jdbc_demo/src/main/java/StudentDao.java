import java.sql.SQLException;
import java.util.List;

/**
 * @author <a href="mailto:phuongdp.tech@gmail.com">PhuongDP</a>
 */
// Data access object
public interface StudentDao {

    List<Student> getAll() throws SQLException;
    Student getById(int id) throws SQLException;
    boolean insert(Student student) throws SQLException;
}

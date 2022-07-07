import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:phuongdp.tech@gmail.com">PhuongDP</a>
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> getAll() throws SQLException {
        List<Student> studentList = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Student");
            while (rs.next()) {
                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                LocalDate dateOfBirth = rs.getDate(3) != null
                        ? rs.getDate(3).toLocalDate() : null;
                int mark = rs.getInt(4);

                Student student = new Student(id, fullName, dateOfBirth, mark);
                studentList.add(student);
            }
        }
        return studentList;
    }

    @Override
    public Student getById(int targetId) throws SQLException {
        // SQL Injection
        // targetId =
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Student WHERE Id = ?");
            preparedStatement.setInt(1, targetId);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("Id");
                String fullName = rs.getString("FullName");
                LocalDate dateOfBirth = rs.getDate("DateOfBirth") != null
                        ? rs.getDate("DateOfBirth").toLocalDate() : null;
                int mark = rs.getInt("Mark");

                return new Student(id, fullName, dateOfBirth, mark);
            }

            return null;
        }
    }

    @Override
    public boolean insert(Student student) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO Student VALUES (?, ?, ?)");
            statement.setString(1, student.getFullName());
            statement.setDate(2, java.sql.Date.valueOf(student.getDateOfBirth()));
            statement.setInt(3, student.getMark());

            return statement.executeUpdate() > 0;
        }
    }
}

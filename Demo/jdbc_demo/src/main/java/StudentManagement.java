import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author <a href="mailto:phuongdp.tech@gmail.com">PhuongDP</a>
 */
public class StudentManagement {
    public static void main(String[] args) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> studentList = studentDao.getAll();
        studentList.forEach(System.out::println);
        System.out.println("-----------");
        Student student01 = studentDao.getById(1);
        Student student04 = studentDao.getById(4);
        System.out.println(student01);
        System.out.println(student04);
        System.out.println("----------------");

        Student student = new Student();
        student.setFullName("New student");
        student.setDateOfBirth(LocalDate.now().minusYears(18));
        student.setMark(90);

        boolean success = studentDao.insert(student);
        System.out.println("Insert student success: " + success);
    }
}

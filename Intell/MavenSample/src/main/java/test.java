import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class test {
    public static void main(String[] args) {
        DbContext db = new DbContext();
        //Connection getConnection(conn);
        try {

            // connnect to database 'testdb'
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("select * from Student");
            // show data
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " + rs.getString(2)
                        + " | " + rs.getString(3)+ " | "+rs.getString(4));
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

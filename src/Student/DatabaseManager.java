package Student;

import java.sql.*;
import java.util.List;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/ORCLpdb";
    private static final String USER = "orclpdbuser";
    private static final String PASSWORD = "isdb62";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }


    public void insertStudents(Connection connection, List<Student> students) throws SQLException {
        String insertSQL = "INSERT INTO students (id, name, class, age, class_teacher, mark) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            for (Student student : students) {
                pstmt.setInt(1, student.getId());
                pstmt.setString(2, student.getName());
                pstmt.setString(3, student.getStudentClass());
                pstmt.setInt(4, student.getAge());
                pstmt.setString(5, student.getClassTeacher());
                if (student.getMark() == null) {
                    pstmt.setNull(6, Types.INTEGER);
                } else {
                    pstmt.setInt(6, student.getMark());
                }
                pstmt.executeUpdate();
            }
            System.out.println("Students inserted into the database.");
        }
    }

    public void fetchStudents(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM students";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            System.out.println("Fetching students from the database:");
            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Class: %s, Age: %d, Teacher: %s, Mark: %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getString("class"),
                        rs.getInt("age"), rs.getString("class_teacher"),
                        rs.getObject("mark")); // Use getObject for nullable fields
            }
        }
    }

    public void updateMarks(Connection connection) throws SQLException {
        String updateSQL = """
            UPDATE students
            SET mark = CASE
                WHEN mark IS NOT NULL AND mark * 1.1 > 100 THEN 100
                WHEN mark IS NOT NULL THEN mark * 1.1
                ELSE mark
            END
            """;
        try (Statement stmt = connection.createStatement()) {
            int rowsUpdated = stmt.executeUpdate(updateSQL);
            System.out.printf("Updated marks for %d students.%n", rowsUpdated);
        }
    }

    public void deleteInvalidStudents(Connection connection) throws SQLException {
        String deleteSQL = "DELETE FROM students where id = 1 ";
        try (Statement stmt = connection.createStatement()) {
            int rowsDeleted = stmt.executeUpdate(deleteSQL);
            System.out.printf("Deleted %d students with null or zero marks.%n", rowsDeleted);
        }
    }
}

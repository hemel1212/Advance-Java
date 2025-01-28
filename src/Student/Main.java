package Student;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();

        // 5 student objects
        List<Student> students = Arrays.asList(
                new Student(1, "Alice", "10A", 15, "Mr. Brown", 85),
                new Student(2, "Bob", "10A", 16, "Mr. Brown", null),
                new Student(3, "Charlie", "10B", 15, "Ms. Green", 78),
                new Student(4, "Diana", "10B", 14, "Ms. Green", 92),
                new Student(5, "Eve", "10C", 16, "Mr. White", 50)
        );

        try (Connection connection = dbManager.connect()) {
            System.out.println("Connected to the database!");

            // Create the table
//            dbManager.createTable(connection);

            // Insert
          // dbManager.insertStudents(connection, students);

            // Fetch and display
           // dbManager.fetchStudents(connection);

            // Update marks
            //dbManager.updateMarks(connection);

            // Delete
           dbManager.deleteInvalidStudents(connection);

            // Fetch and display students again
          //  dbManager.fetchStudents(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

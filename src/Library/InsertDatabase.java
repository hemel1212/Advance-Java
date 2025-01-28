package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDatabase extends Connections {
    public void insertDatabase(String[][] books) {
        String insertQuery = "INSERT INTO BookD (title, author, year, pages, price) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            for (String[] book : books) {
                preparedStatement.setString(1, book[0]); // title
                preparedStatement.setString(2, book[1]); // author
                preparedStatement.setInt(3, Integer.parseInt(book[2])); // year
                preparedStatement.setInt(4, Integer.parseInt(book[3])); // pages
                preparedStatement.setDouble(5, Double.parseDouble(book[4])); // price

                preparedStatement.addBatch();
            }

            int[] rowsInserted = preparedStatement.executeBatch();
            System.out.println("Rows inserted: " + rowsInserted.length);

        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
    }
}
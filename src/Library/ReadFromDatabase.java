package Library;

import java.sql.*;
import java.util.ArrayList;

public class ReadFromDatabase extends Connections {

    StringBuilder output = new StringBuilder();


    public ArrayList<String> readFromDatabase() {
        String selectQuery = "SELECT * FROM BookD"; // SQL query
        ArrayList<String> productsData = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {

            while (resultSet.next()) {
                // Retrieve data from each column
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int year = resultSet.getInt("year");
                int pages = resultSet.getInt("pages");
                double price = resultSet.getDouble("price");

                // Format the row data
                String bookDetails = String.format("ID: %d, Title: %s, Author: %s, Year: %d, Pages: %d, Price: %.2f",
                        id, title, author, year, pages, price);

                // Add formatted data to ArrayList
                productsData.add(bookDetails);

                // Append the formatted data to the StringBuilder
                output.append(bookDetails).append("\n");
            }
        } catch (SQLException e) {
            System.err.println("Error selecting data: " + e.getMessage());
        }
        return productsData;
    }

    // Method to print the data read from the database
    public void readFromDatabasePrint() {
        if (output.length() > 0) {
            System.out.println(output);
        } else {
            System.out.println("No data found in the database.");
        }
    }
}

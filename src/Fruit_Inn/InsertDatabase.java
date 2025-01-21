package Fruit_Inn;

import java.sql.*;

public class InsertDatabase extends Connections {
    public void insertDatabase(String[][] products) {
        String insertQuery = "INSERT INTO Fruit (id, name, buyer, seller, price, buy_date, sell_date) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            for (String[] product : products) {
                preparedStatement.setInt(1, Integer.parseInt(product[0])); //name
                preparedStatement.setString(2, product[1]); //name
                preparedStatement.setString(3, product[2]); //buyer
                preparedStatement.setString(4, product[3]); //seller
                preparedStatement.setDouble(5, Double.parseDouble(product[4])); //price
                preparedStatement.setDate(6, Date.valueOf(product[5])); //buy date
                preparedStatement.setDate(7, Date.valueOf(product[6])); //sell date

                preparedStatement.addBatch();
            }

            int[] rowsInserted = preparedStatement.executeBatch();
            System.out.println("Rows inserted: " + rowsInserted.length);

        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
    }

}

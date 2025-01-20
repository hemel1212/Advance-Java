package Fruit_Inn;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

public class ReadFromDatabase extends Connections {
    StringBuilder output = new StringBuilder();
    public ArrayList<String> readFromDatabase() {
        String selectQuery = "SELECT * FROM jdbc_fruit_product";
        ArrayList<String> productsData = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);


            output.append(String.format("%-3s %-10s %-10s %-10s %-6s %-15s %-15s\n", "id", "name", "buyer", "seller", "price", "buy_date", "sell_date"));
            output.append(String.format("--------------------------\n"));
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String buyer = resultSet.getString("buyer");
                String seller = resultSet.getString("seller");
                int price = resultSet.getInt("price");
                String buy_date = resultSet.getString("buy_date");
                String sell_date = resultSet.getString("sell_date");

                output.append(String.format("%-3d %-10s %-10s %-10s %-6d %-15s %-15s\n", id, name, buyer, seller, price, buy_date, sell_date));

                productsData.add(id + "," + name + "," + buyer + "," + seller + "," + price + "," + buy_date + "," + sell_date);
            }
        } catch (SQLException e) {
            System.err.println("Error selecting data: " + e.getMessage());
        }
        return productsData;
    }

    public void readDataFromDatabasePrint() {
        System.out.println(output);
    }
}

package Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();

        // Create 5 product objects
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 10, "Dell"),
                new Product(2, "Smartphone", 25, "Samsung"),
                new Product(3, "Tablet", 15, "Apple"),
                new Product(4, "Headphones", 30, "Sony"),
                new Product(5, "Smartwatch", 20, "Fitbit")
        );

        try (Connection connection = dbManager.connect()) {
            System.out.println("Connected to the database!");

            // Create the table
           // dbManager.createTable(connection);

            // Insert products
            //dbManager.insertProducts(connection, products);

            // Fetch and display all products
           // dbManager.fetchProducts(connection);

            // Update a product's quantity
           dbManager.updateProductQuantity(connection, 3, 3); // Update product with ID 3 to a quantity of 18

            // Fetch and display products again to confirm the update
           // dbManager.fetchProducts(connection);

            // Delete a product by ID
           // dbManager.deleteProduct(connection, 2); // Delete product with ID 2

            // Fetch and display products again to confirm the deletion
            //dbManager.fetchProducts(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


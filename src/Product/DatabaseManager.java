package Product;

import java.sql.*;
import java.util.List;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/ORCLpdb";
    private static final String USER = "orclpdbuser";
    private static final String PASSWORD = "isdb62";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }



    public void insertProducts(Connection connection, List<Product> products) throws SQLException {
        String insertSQL = "INSERT INTO products (id, name, quantity, brand) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            for (Product product : products) {
                pstmt.setInt(1, product.getId());
                pstmt.setString(2, product.getName());
                pstmt.setInt(3, product.getQuantity());
                pstmt.setString(4, product.getBrand());
                pstmt.executeUpdate();
            }
            System.out.println("Products inserted into the database.");
        }
    }

    public void updateProductQuantity(Connection connection, int productId, int newQuantity) throws SQLException {
        String updateSQL = "UPDATE products SET quantity = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
            pstmt.setInt(1, newQuantity);
            pstmt.setInt(2, productId);
            int rowsUpdated = pstmt.executeUpdate();
            System.out.printf("Updated quantity for %d product(s).%n", rowsUpdated);
        }
    }

    public void deleteProduct(Connection connection, int productId) throws SQLException {
        String deleteSQL = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, productId);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.printf("Deleted %d product(s) with ID %d.%n", rowsDeleted, productId);
        }
    }

    public void fetchProducts(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM products";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            System.out.println("Fetching products from the database:");
            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Quantity: %d, Brand: %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"), rs.getString("brand"));
            }
        }
    }
}

package Exam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crudo_Peration {


    //insert product..
    public void insertProduct(String s){

        try (Connection connection = DatabaseConnection.orclConnection();
             Statement statement = connection.createStatement()){

            int rowAffected = statement.executeUpdate(s);
            if (rowAffected>0){
                System.out.println("Insert product successfully");
            }else {
                System.out.println("Insert product failed!");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void fetchProduct(String s){

        try (Connection connection = DatabaseConnection.orclConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(s)){

            System.out.println("========= Product Info =========");
            while (resultSet.next()){
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                int qty =resultSet.getInt("product_qty");
                String brand = resultSet.getString("product_brand");

                System.out.println("ID: " + id + "\nName: " + name +
                        "\nQuantity: " + qty + "\nBrand: " + brand);
                System.out.println("======================================");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    //insert product..
    public void updateProduct(String s){

        try (Connection connection = DatabaseConnection.orclConnection();
             Statement statement = connection.createStatement()){

            int rowAffected = statement.executeUpdate(s);
            if (rowAffected>0){
                System.out.println("Update successfully");
            }else {
                System.out.println("Failed update!");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }




    //Delete Product.
    public void deleteProduct(String s){

        try(Connection connection= DatabaseConnection.orclConnection();
            Statement statement = connection.createStatement()){

            int rowAffected =statement.executeUpdate(s);
            if (rowAffected>0){
                System.out.println("Product delete successfully");
            }else{
                System.out.println("Product deletion failed!");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

}

package Exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";
    private static final String USER = "orclpdbuser";
    private static final String PASSWORD = "isdb62";

    public static Connection orclConnection() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}

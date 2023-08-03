package JDBC_CRUD;

import java.sql.*;

public class connectionfile {
    static String url = "jdbc:sqlserver://MSI\\SQLCHECK:1433;databaseName=student;encrypt=false;";
    static String username = "sa";
    static String password = "sqlpswd11";

    static Connection connection; // coz static method can only access static values

    public static Connection connectionfunction() {

        try {
            // Load the MS SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish the database connection
             connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

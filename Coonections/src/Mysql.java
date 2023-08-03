import java.sql.*;

public class Mysql {
    static String url = "jdbc:mysql://localhost:3306/testdb1";
    static String username = "root";
    static String password = "Mypswd1123@";
    static void mysqlcon(){
                // Database connection parameters


                try {
                    // Load the MySQL JDBC driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Establish the database connection
                    Connection connection = DriverManager.getConnection(url, username, password);

                    // Create a statement object to execute SQL queries
                    Statement statement = connection.createStatement();

                    // SQL query to fetch all records from the 'employee' table
                    String sqlQuery = "SELECT * FROM student";

                    // Execute the query and get the result set
                    ResultSet resultSet = statement.executeQuery(sqlQuery);

                    // Process the result set
                    while (resultSet.next()) {

                        String name = resultSet.getString("FirstName");


                        // Print the retrieved data

                        System.out.println("Name: " + name);

                    }

                    // Close the resources
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        }
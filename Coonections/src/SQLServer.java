import java.sql.*;

public class SQLServer {
    static String url = "jdbc:sqlserver://MSI\\SQLCHECK:1433;databaseName=student;encrypt=false;";
    static String username = "sa";
    static String password = "sqlpswd11";

    public static void connectionfunction() {

        try {
            // Load the MS SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish the database connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement object to execute SQL queries
            Statement statement = connection.createStatement();

            // SQL query to fetch all records from the 'employee' table
            String sqlQuery = "SELECT * FROM Person";

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Process the result set
            while (resultSet.next()) {

                String city = resultSet.getString("City");

                System.out.println("City: " + city);

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

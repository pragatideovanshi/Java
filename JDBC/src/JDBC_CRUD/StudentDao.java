package JDBC_CRUD;

import java.sql.*;

public class StudentDao {

    public static boolean insertdata(Student st){
        boolean flag=false;
        try {
            Connection cn = connectionfile.connectionfunction();
            String query = "Insert into Persons(LastName,FirstName,Age) values(?,?,?)";
            PreparedStatement pq = cn.prepareStatement(query);
            pq.setString(1,st.st_first_name);
            pq.setString(2,st.st_last_name);
            pq.setInt(3,st.st_age);
            pq.executeUpdate(); // return nothing
            flag=true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public void getdata(){

    }
    public static boolean deletedata(int userid) {
        boolean flag = false;
        Connection cn = connectionfile.connectionfunction();
        String query = "delete from Persons where ID=?";
        try {
            PreparedStatement pq = cn.prepareStatement(query);
            pq.setInt(1, userid);
            pq.execute();
            flag=true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public static void showdata(){
        boolean flag = false;
        Connection cn = connectionfile.connectionfunction();
        String query = "Select * from Persons";
        try {
            Statement s = cn.createStatement();
            ResultSet result=s.executeQuery(query);
            while(result.next()){
                int id=result.getInt("ID");
                String first=result.getString("FirstName");
                int Age=result.getInt("Age");
                System.out.println(id+" "+first+" "+Age);
            }
            flag=true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void getbyid(int userid){
        Connection cn = connectionfile.connectionfunction();
        String query = "Select * from Persons where id=?";
        try {
            String sqlQuery = "SELECT * FROM Persons WHERE id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(sqlQuery);

            // Set the ID parameter in the prepared statement
            preparedStatement.setInt(1, userid);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if a record was found and process the data
            if (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("FirstName");
                // Continue extracting other fields as needed

                // Process the data (e.g., display, use it in your application, etc.)
                System.out.println("Record found:");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
            } else {
                System.out.println("No record found with ID: " );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

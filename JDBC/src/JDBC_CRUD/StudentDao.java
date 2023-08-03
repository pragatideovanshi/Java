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
}

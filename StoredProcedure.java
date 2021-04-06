import java.sql.*;
//package StoredProcedure;
public class StoredProcedure
{
     public static void main(String[] args) 
     {
        try{
            //connection string for driver class name
            Class.forName("com.mysql.jdbc.Driver");
            //connection string
            String url="jdbc:mysql://localhost:3306/student_info";
            Connection con=DriverManager.getConnection(url, "user", "password");
            System.out.println("connection establish");

            //using statement to execute query
            Statement stmt=con.createStatement();
            int query=stmt.executeUpdate("Insert into student_table values(107,'shreya patel')");
            System.out.println("query executed"+query);
            stmt.close();

            //using prepared statement
            PreparedStatement update_table=con.prepareStatement("insert into student_table values(108,'Ajima patel')");
            update_table.setInt(1, 108);
            update_table.setString(1, "toby lefty");
            update_table.executeUpdate();
            


        }
        catch(Exception e){
                System.out.println("exception occured"+e.getMessage());
        }
    }


}

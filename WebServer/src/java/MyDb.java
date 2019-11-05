import java.sql.*;

public class MyDb {
    static Connection con=null;
    public static Connection getCon()
    {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Antonis123#");
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
}

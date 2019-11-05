import java.sql.*;

public class UserDAOImpl implements UserDAO{
    
    static Connection con;
    static PreparedStatement s;
    
    @Override
    public int insertUser(User u){
        int status=0;
        try{ 
            con = MyDb.getCon();
            s=con.prepareStatement("INSERT INTO user values(?,?)");
            s.setString(1, u.getName());
            s.setString(2, u.getPassword());
            status=s.executeUpdate();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return status;
        
    }

    @Override
    public User getUser(String name, String psw) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        User u=new User();
        try{
            con = MyDb.getCon();
            s=con.prepareStatement("SELECT * FROM user WHERE name = ? AND password = ?");
            s.setString(1, name);
            s.setString(2, psw);
            
            ResultSet rs=s.executeQuery();
            
            while(rs.next()){
                u.setName(rs.getString(1));
                u.setPassword(rs.getString(2));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return u;
    }
}

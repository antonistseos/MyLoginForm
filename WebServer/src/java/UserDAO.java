public interface UserDAO {
    public int insertUser(User u);
    public User getUser(String name, String psw);
}
 
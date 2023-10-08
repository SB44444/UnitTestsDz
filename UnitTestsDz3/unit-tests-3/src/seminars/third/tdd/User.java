package seminars.third.tdd;
import seminars.third.tdd.User;
public class User {

    String name;
    String password;

    boolean isAdmin;

    boolean isAuthenticate;

    public User(String name, String password, boolean isAdmin, boolean isAuthenticate) {
        this.name = name;
        this.password = password;
        this.isAuthenticate = isAuthenticate;
        this.isAdmin = isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }

    public void setAuthenticate(boolean authenticate) {
        isAuthenticate = authenticate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean authenticate(String userName, String userPassword) {
        return name.equals(userName) && password.equals(userPassword);

    }

}
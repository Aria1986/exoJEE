package Entity;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;

    private String pwd;
    private String email;
    public User(){

    }
    public User(String name, String pwd){
        this.setUserName(name);
        this.setPwd( BCrypt.hashpw(pwd, BCrypt.gensalt()));
    }
    public User(String name, String pwd,String email){
        this.setUserName(name);
        this.setPwd( BCrypt.hashpw(pwd, BCrypt.gensalt()));
        this.setEmail(email);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

package naumen.project.shop.models;

<<<<<<< Updated upstream
import javax.persistence.*;

@Entity
@Table(name = "users_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;

    protected User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

=======
public class User {

    private String login;
    private String password;
    private int id;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

>>>>>>> Stashed changes
    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

<<<<<<< Updated upstream
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
=======
    public int getId() { return id; }

    public void setId(int id) {this.id = id; }
>>>>>>> Stashed changes
}

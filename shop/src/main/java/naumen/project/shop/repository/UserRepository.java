package naumen.project.shop.repository;

<<<<<<< Updated upstream
import naumen.project.shop.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByLogin(String login);
=======
import naumen.project.shop.ShopApplication;
import naumen.project.shop.models.Smartphone;
import naumen.project.shop.models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRepository {

    public static Properties readProperties() {

        Properties props = new Properties();
        Path myPath = Paths.get("src/main/resources/application.properties");

        try {
            BufferedReader bf = Files.newBufferedReader(myPath,
                    StandardCharsets.UTF_8);

            props.load(bf);
        } catch (IOException ex) {
            Logger.getLogger(ShopApplication.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

        return props;
    }

    public static  void AddUser(User user) throws SQLException {
        Connection con = GetConnection(readProperties());
        String sql = "INSERT INTO public.users_table (login, password) VALUES (?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, user.getLogin());
        pst.setString(2, user.getPassword());
        pst.executeQuery();
    }

    public static Boolean CheckUser(User user) throws SQLException {
        Connection con = GetConnection(readProperties());
        String sql = "SELECT * FROM public.users_table WHERE login = ? AND password = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, user.getLogin());
        pst.setString(2, user.getPassword());
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }

    private static Connection GetConnection(Properties props) throws SQLException
    {
        String url = props.getProperty("spring.datasource.url");
        String user = props.getProperty("spring.datasource.username");
        String passwd = props.getProperty("spring.datasource.password");
        return DriverManager.getConnection(url, user, passwd);
    }
>>>>>>> Stashed changes
}

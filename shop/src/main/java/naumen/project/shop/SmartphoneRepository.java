package naumen.project.shop;

import naumen.project.shop.models.Smartphone;
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

public class SmartphoneRepository {

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

    public static ArrayList<Smartphone> GetAllSmartphones() throws SQLException {
        Properties props = readProperties();
        String url = props.getProperty("spring.datasource.url");
        String user = props.getProperty("spring.datasource.username");
        String passwd = props.getProperty("spring.datasource.password");

        Connection con = DriverManager.getConnection(url, user, passwd);
        PreparedStatement pst = con.prepareStatement("SELECT * FROM smartphones_table");
        ResultSet rs = pst.executeQuery();

        var Smartphones = new ArrayList<Smartphone>();
        while (rs.next()) {
            var tempSmartphones = new Smartphone();
            tempSmartphones.setId(rs.getInt(1));
            tempSmartphones.setOS(rs.getString(2));
            tempSmartphones.setName(rs.getString(3));
            tempSmartphones.setImg(rs.getString(4));
            Smartphones.add(tempSmartphones);
        }
        return Smartphones;
    }

    public static ArrayList<Smartphone> GetSmartphonesByOS(String OS) throws SQLException {
        Properties props = readProperties();
        String url = props.getProperty("spring.datasource.url");
        String user = props.getProperty("spring.datasource.username");
        String passwd = props.getProperty("spring.datasource.password");
        String sql = "SELECT * FROM smartphones_table WHERE os = ?";

        Connection con = DriverManager.getConnection(url, user, passwd);
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,OS);
        ResultSet rs = pst.executeQuery();

        var smartphones = new ArrayList<Smartphone>();
        while (rs.next()) {
            var tempSmartphones = new Smartphone();
            tempSmartphones.setId(rs.getInt(1));
            tempSmartphones.setOS(rs.getString(2));
            tempSmartphones.setName(rs.getString(3));
            tempSmartphones.setImg(rs.getString(4));
            smartphones.add(tempSmartphones);
        }
        return smartphones;
    }
}

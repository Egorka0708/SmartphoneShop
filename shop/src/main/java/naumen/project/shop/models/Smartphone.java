package naumen.project.shop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "smartphones_table")
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String OS;

    private String name;

    private String img;

    private int price;

    protected Smartphone() {}

    public Smartphone(long id, String OS, String name, String img, int price) {
        this.id = id;
        this.OS = OS;
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getImg() { return img; }

    public void setImg(String img) { this.img = img; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getOS() { return OS; }

    public void setOS(String OS) { this.OS = OS; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }
}

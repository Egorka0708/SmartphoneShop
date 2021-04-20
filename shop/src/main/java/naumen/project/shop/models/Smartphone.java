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

    protected Smartphone() {}

    public Smartphone(long id, String OS, String name, String img) {
        this.id = id;
        this.OS = OS;
        this.name = name;
        this.img = img;
    }

    @Override
    public String toString() {
        return String.format(
                "Smartphone[id=%d, OS='%s', name='%s']",
                id, OS, name);
    }

    public String getImg() { return img; }

    public void setImg(String img) { this.img = img; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getOS() { return OS; }

    public void setOS(String OS) { this.OS = OS; }
}

package naumen.project.shop.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shopcart_table")
public class ShopCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Smartphone> smartphoneList;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    public ShopCart() {}

    public long getId() { return id; }

    public void setId() { this.id = id; }

    public List<Smartphone> getSmartphoneList() {
        return smartphoneList;
    }

    public void setSmartphoneList(List<Smartphone> smartphoneList) {
        this.smartphoneList = smartphoneList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

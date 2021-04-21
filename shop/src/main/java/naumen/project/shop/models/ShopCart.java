package naumen.project.shop.models;

import javax.persistence.*;

@Entity
@Table(name = "shopcart_table")
public class ShopCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idSmartphone;

    protected ShopCart() {}

    public ShopCart(long id, long idSmartphone) {
        this.id = id;
        this.idSmartphone = idSmartphone;
    }

    public long getId() { return id; }

    public void setId() { this.id = id; }

    public long getIdSmartphone() { return idSmartphone; }

    public void setIdSmartphone() { this.idSmartphone = idSmartphone; }
}

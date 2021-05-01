package naumen.project.shop.repository;

import naumen.project.shop.models.ShopCart;
import naumen.project.shop.models.Smartphone;
import naumen.project.shop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopCartRepository extends JpaRepository<ShopCart, Long> {
    ShopCart findShopCartByUser(User user);
    List<ShopCart> findAll();
}

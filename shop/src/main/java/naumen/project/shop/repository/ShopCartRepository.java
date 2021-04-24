package naumen.project.shop.repository;

import naumen.project.shop.models.ShopCart;
import naumen.project.shop.models.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopCartRepository extends JpaRepository<ShopCart, Long> {

    Smartphone findById(long id);
}

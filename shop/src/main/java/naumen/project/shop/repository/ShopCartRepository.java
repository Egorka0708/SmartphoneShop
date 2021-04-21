package naumen.project.shop.repository;

import naumen.project.shop.models.ShopCart;
import naumen.project.shop.models.Smartphone;
import org.springframework.data.repository.CrudRepository;

public interface ShopCartRepository extends CrudRepository<ShopCart, Long> {

    Smartphone findById(long id);
}

package naumen.project.shop.repository;

import naumen.project.shop.models.Smartphone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SmartphoneRepository extends CrudRepository<Smartphone, Long> {

    Smartphone findById(long id);
    List<Smartphone> findAll();
    List<Smartphone> findAllByOS(String OS);
}

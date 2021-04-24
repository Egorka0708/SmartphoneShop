package naumen.project.shop.repository;

import naumen.project.shop.models.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

    Smartphone findById(long id);
    List<Smartphone> findAll();
    List<Smartphone> findAllByOS(String OS);
}

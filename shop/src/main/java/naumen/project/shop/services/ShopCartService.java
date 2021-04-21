package naumen.project.shop.services;

import naumen.project.shop.models.Smartphone;
import naumen.project.shop.repository.ShopCartRepository;
import naumen.project.shop.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCartService {
    @Autowired
    ShopCartRepository shopCartRepository;
    @Autowired
    SmartphoneRepository smartphoneRepository;

    public Smartphone getById(long id) {
        return smartphoneRepository.findById(id);
    }
}

package naumen.project.shop.services;

import naumen.project.shop.models.Smartphone;
import naumen.project.shop.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService {
    @Autowired
    SmartphoneRepository smartphoneRepository;

    public List<Smartphone> allSmartphones() {
        return smartphoneRepository.findAll();
    }

    public List<Smartphone> findSmartphonesByOS(String OS) {
        return smartphoneRepository.findAllByOS(OS);
    }

    public Smartphone findSmartphoneById(long id) { return smartphoneRepository.findById(id); }

    public Smartphone save(Smartphone smartphone) {return  smartphoneRepository.save(smartphone); }

}

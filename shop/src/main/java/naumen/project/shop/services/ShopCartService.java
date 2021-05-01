package naumen.project.shop.services;

import naumen.project.shop.models.ShopCart;
import naumen.project.shop.models.Smartphone;
import naumen.project.shop.models.User;
import naumen.project.shop.repository.ShopCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShopCartService {

    @Autowired
    ShopCartRepository shopCartRepository;

    public ShopCart getShopcart(User user, Smartphone smartphone) {
        var shopcartDB = shopCartRepository.findShopCartByUser(user);
        if (shopcartDB != null)
        {
            var smartphoneList = shopcartDB.getSmartphoneList();
            smartphoneList.add(smartphone);
            shopcartDB.setSmartphoneList(smartphoneList);
            shopCartRepository.save(shopcartDB);
            return shopcartDB;
        }
        else
        {
            var smartphoneList = Arrays.asList(smartphone);
            var shopcart = new ShopCart();
            shopcart.setUser(user);
            shopcart.setSmartphoneList(smartphoneList);
            shopCartRepository.save(shopcart);
            return shopcart;
        }
    }
}

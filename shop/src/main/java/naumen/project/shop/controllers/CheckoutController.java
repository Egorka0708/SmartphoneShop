package naumen.project.shop.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import naumen.project.shop.models.ShopCart;
import naumen.project.shop.repository.ShopCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class CheckoutController {

    @Autowired
    ShopCartRepository shopCartRepository;

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView contacts() {
        ModelAndView mav = new ModelAndView("checkout");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else if (principal.toString() != "anonymousUser") {
            var user = principal.toString().split("given_name=");
            var user_name = user[1].toString().split(",");
            username = user_name[0];
        }
        else {
            username = principal.toString();
        }
        boolean isAuth = false;
        if (username != "anonymousUser")
            isAuth = true;

        try {
            Serialization();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mav.addObject("username", username);
        mav.addObject("isAuth", isAuth);
        return mav;
    }

    public void Serialization () throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ShopCart> shopCarts = shopCartRepository.findAll();
        objectMapper.writeValue(new File("src\\main\\resources\\JSON\\ser.json"), shopCarts);
    }
}

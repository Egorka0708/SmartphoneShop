package naumen.project.shop.controllers;

import naumen.project.shop.services.ShopCartService;
import naumen.project.shop.services.SmartphoneService;
import naumen.project.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;
    @Autowired
    private UserService userService;
    @Autowired
    private SmartphoneService smartphoneService;

    @RequestMapping(value = "/shopcart/{id}", method = RequestMethod.GET)
    public ModelAndView shopcart(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("shopcart");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        boolean isAuth = false;
        if (username != "anonymousUser")
            isAuth = true;

        var shopCart = shopCartService.getShopcart(userService.findUser(username), smartphoneService.findSmartphoneById(id));
        mav.addObject("username", username);
        mav.addObject("isAuth", isAuth);
        mav.addObject("smartphones", shopCart.getSmartphoneList());
        return mav;
    }
}

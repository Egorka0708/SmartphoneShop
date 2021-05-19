package naumen.project.shop.controllers;

import naumen.project.shop.services.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private SmartphoneService smartphoneService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("index");
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



        mav.addObject("username", username);
        mav.addObject("isAuth", isAuth);
        mav.addObject("Smartphones", smartphoneService.allSmartphones());
        return mav;
    }
}

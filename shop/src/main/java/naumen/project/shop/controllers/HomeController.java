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

        ModelAndView mav = new ModelAndView("index");

        mav.addObject("username", username);
        mav.addObject("isAuth", isAuth);
        mav.addObject("Smartphones", smartphoneService.allSmartphones());
        return mav;
    }


}

package naumen.project.shop.controllers;

import naumen.project.shop.services.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactsController {
    @Autowired
    private SmartphoneService smartphoneService;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public ModelAndView contacts() {
        ModelAndView mav = new ModelAndView("map");
        return mav;
    }
}

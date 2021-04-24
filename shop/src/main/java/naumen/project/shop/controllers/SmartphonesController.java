package naumen.project.shop.controllers;

import naumen.project.shop.services.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SmartphonesController {

    @Autowired
    private SmartphoneService smartphoneService;

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ModelAndView getSmartphonesList(@PathVariable String category) {
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("SmartphonesByOS", smartphoneService.findSmartphonesByOS(category));
        return mav;
    }
}
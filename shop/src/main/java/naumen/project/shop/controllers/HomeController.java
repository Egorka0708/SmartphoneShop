package naumen.project.shop.controllers;

import naumen.project.shop.SmartphoneRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@RestController
public class HomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("index");
        try {mav.addObject("Smartphones", SmartphoneRepository.GetAllSmartphones()); }
        catch (SQLException e) { }
        return mav;
    }
}

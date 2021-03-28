package naumen.project.shop.controllers;

import naumen.project.shop.SmartphoneRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@RestController
public class AndroidController {

    @RequestMapping(value = "/android", method = RequestMethod.GET)
    public ModelAndView getAppleSmartphones() {
        ModelAndView mav = new ModelAndView("android");
        try { mav.addObject("Smartphones", SmartphoneRepository.GetSmartphonesByOS("Android")); }
        catch (SQLException e) { }
        return mav;
    }
}
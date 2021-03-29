package naumen.project.shop.controllers;

import naumen.project.shop.SmartphoneRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@RestController
public class SmarthponesController {

    @RequestMapping(value = {"/category/{category}"}, method = RequestMethod.GET)
    public ModelAndView getSmartphonesList(@PathVariable String category) {
        ModelAndView mav = new ModelAndView("list");
        try { mav.addObject("SmartphonesByOS", SmartphoneRepository.GetSmartphonesByOS(category)); }
        catch (SQLException e) { }
        return mav;
    }
}
package naumen.project.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckoutController {

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView contacts() {
        ModelAndView mav = new ModelAndView("checkout");
        return mav;
    }
}

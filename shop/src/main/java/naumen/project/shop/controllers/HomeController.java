package naumen.project.shop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@RestController
public class HomeController {

    @RequestMapping(value="/home", method= RequestMethod.GET)
    public String home(@RequestParam(name="home", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("home", name);
        return "home";
    }
}

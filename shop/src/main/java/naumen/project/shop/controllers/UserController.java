package naumen.project.shop.controllers;

import naumen.project.shop.models.User;
import naumen.project.shop.services.SmartphoneService;
import naumen.project.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationForm(Model model){
        User user = new User("","");
        model.addAttribute("user",user);
        return "registration";
    }

    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public String registrationSubmit(@RequestParam String login, @RequestParam String password, Model model) {
        var user = new User(login, password);
        model.addAttribute("user", user);
        System.out.print(userService.saveUser(user));
        return "result";
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public String authorizationForm(Model model){
        User user = new User("","");
        model.addAttribute("user",user);
        return "authorization";
    }

    @RequestMapping(value="/authorization", method = RequestMethod.POST)
    public String authorizationSubmit(@RequestParam String login, @RequestParam String password, Model model) {
        var user = new User(login, password);
        model.addAttribute("user", user);
        var checkUser = userService.findUser(login);
        if (checkUser != null) //checkUser.getPassword().equals(password)
            return "result";
        else
            return "redirect:/authorization";
    }
}

package naumen.project.shop.controllers;

import naumen.project.shop.models.User;
<<<<<<< Updated upstream
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
=======
import naumen.project.shop.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@Controller
public class UserController {

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        try { UserRepository.AddUser(user); }
        catch (SQLException e) {System.out.println(e.getMessage()); }
        return "result";
    }

    @PostMapping("/authorization")
    public String authorizationSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        Boolean exists;
        try { exists = UserRepository.CheckUser(user); }
        catch (SQLException e) {System.out.println(e.getMessage()); }
        return "result";
    }



}

>>>>>>> Stashed changes

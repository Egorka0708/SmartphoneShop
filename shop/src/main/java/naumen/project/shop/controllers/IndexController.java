package naumen.project.shop.controllers;

import java.security.Principal;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for sending the user to the login view.
 *
 * @author Rob Winch
 *
 */

@Controller
public class IndexController {

    // tag::findbyusername[]
    @Autowired
    FindByIndexNameSessionRepository<? extends Session> sessions;

    @RequestMapping("/")
    public String index(Principal principal, Model model) {
        Collection<? extends Session> usersSessions = this.sessions.findByPrincipalName(principal.getName()).values();
        model.addAttribute("sessions", usersSessions);
        return "index";
    }
    // end::findbyusername[]

    @PostMapping("/sessions/{sessionIdToDelete}")
    public String removeSession(Principal principal, @PathVariable String sessionIdToDelete) {
        Set<String> usersSessionIds = this.sessions.findByPrincipalName(principal.getName()).keySet();
        if (usersSessionIds.contains(sessionIdToDelete)) {
            this.sessions.deleteById(sessionIdToDelete);
        }

        return "redirect:/";
    }

}
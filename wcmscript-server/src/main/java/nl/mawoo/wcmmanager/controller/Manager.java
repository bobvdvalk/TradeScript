package nl.mawoo.wcmmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is the controller of the Manager dashboard
 * The Dashboard views system statistics.
 *
 * @author Bob van der Valk
 */
@Controller
public class Manager {
    @RequestMapping("/")
    public String dashboard() {
        return "dashboard";
    }

    @RequestMapping("/")
    public String login() {
        return "login";
    }
}

package nl.mawoo.wcmmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
@Controller
public class Login {
    @RequestMapping("/login")
    public String loginScreen() {
        return "login";
    }
}

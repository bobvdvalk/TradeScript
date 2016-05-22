package nl.mawoo.wcmmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is the controller for the configuration page
 *
 * @author Bob van der Valk
 */
@Controller
@RequestMapping("/config")
public class Configuration {

    @RequestMapping("")
    public String config() {
        return "configuration";
    }
}

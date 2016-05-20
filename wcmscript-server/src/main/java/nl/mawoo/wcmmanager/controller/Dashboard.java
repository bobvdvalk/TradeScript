package nl.mawoo.wcmmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is responsible for the main dashboard view
 *
 * @author Bob van der Valk
 */
@Controller
@RequestMapping("/")
public class Dashboard {

    /**
     * Show the main overview page
     * @return template/overview.html
     */
    @RequestMapping("")
    public String overview() {
        return "overview";
    }
}

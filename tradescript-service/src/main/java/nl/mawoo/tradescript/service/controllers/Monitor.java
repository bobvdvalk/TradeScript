package nl.mawoo.tradescript.service.controllers;

import com.google.gson.Gson;
import nl.mawoo.tradescript.service.storage.Script;
import nl.mawoo.tradescript.service.storage.ScriptDao;
import nl.mawoo.tradescript.service.storage.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Monitor {

    @Autowired
    private ScriptDao scriptDao;

    @RequestMapping(method = RequestMethod.GET, path = "/overview")
    @ResponseBody
    public String show() {
        Iterable<Script> scripts = scriptDao.findAll();
        return new Gson().toJson(scripts);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/overview")
    public String show(@RequestParam String status) {
        Status st = Status.valueOf(status);
        Iterable<Script> scripts = scriptDao.findAllByStatus(st);
        return new Gson().toJson(scripts);
    }
}

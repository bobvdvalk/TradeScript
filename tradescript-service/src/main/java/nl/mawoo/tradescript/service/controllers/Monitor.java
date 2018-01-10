package nl.mawoo.tradescript.service.controllers;

import nl.mawoo.tradescript.service.storage.Script;
import nl.mawoo.tradescript.service.storage.ScriptDao;
import nl.mawoo.tradescript.service.storage.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Monitor {

    @Autowired
    private ScriptDao scriptDao;

    @RequestMapping("/overview")
    @ResponseBody
    public Iterable<Script> show() {
        return scriptDao.findAll();
    }

    @RequestMapping("/overview/filter")
    @ResponseBody
    public Iterable<Script> showFiltered(@RequestParam String status) {
        Status st = Status.valueOf(status.toUpperCase());
        return scriptDao.findAllByStatus(st);
    }
}

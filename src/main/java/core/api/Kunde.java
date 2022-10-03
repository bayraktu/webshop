package core.api;

import core.models.IncomingMessage;
import core.services.Nachrichtendienst;
import core.models.OutgoingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class Kunde {

    @Autowired
    Nachrichtendienst nachrichtendienst;

    @RequestMapping(path = "/", produces = "application/json")
    public @ResponseBody String getEmployees() {
        System.out.println("GET MESSAGE");
        return "hallo lEUTE WOW ES FUNKTIONIERT";
    }

    @PostMapping(path = "/test", consumes = "application/json", produces = "application/json")
    public void addEmployee(@RequestBody IncomingMessage message) {
        System.out.println("POST MESSAGE");
        nachrichtendienst.pushToQue(message.toString());
    }
}
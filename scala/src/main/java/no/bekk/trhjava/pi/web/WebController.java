package no.bekk.trhjava.pi.web;

import akka.actor.ActorRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static akka.actor.ActorRef.noSender;

@RestController
public class WebController {

    @Autowired
    private ActorRef stringActor;

    @RequestMapping("/say")
    public HttpStatus say(@RequestParam("msg") String message) {
        stringActor.tell(message, noSender());
        return HttpStatus.OK;
    }

}

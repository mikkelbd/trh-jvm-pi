package no.bekk.trhjava.pi.web;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    private ActorSystem system;

    private String actorName = "StringActor";

    @RequestMapping("/say/{member}/{message}")
    public HttpStatus say(@PathVariable("member") String member, @PathVariable("message") String message) {

        ActorSelection actor = system.actorSelection(String.format("akka.tcp://Akka-Pi@%s:2552/user/StringActor", member));
        actor.tell(message, ActorRef.noSender());
        return HttpStatus.OK;
    }

}

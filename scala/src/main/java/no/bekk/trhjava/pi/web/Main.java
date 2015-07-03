package no.bekk.trhjava.pi.web;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import no.bekk.trhjava.pi.actor.StringActor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @Bean
    public ActorSystem actorSystem() {
        return ActorSystem.create("Akka-Pi");
    }

    @Bean
    public ActorRef stringActor() {
        return actorSystem().actorOf(StringActor.mkProps());
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}

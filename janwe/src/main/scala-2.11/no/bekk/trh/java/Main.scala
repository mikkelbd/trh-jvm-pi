package no.bekk.trh.java

import akka.actor.{Props, ActorSystem}

object Main extends App {

  val system = ActorSystem("akka-pi")
  val sender = system.actorOf(Props[SenderActor])
  val receiver = system.actorOf(Props[ReceiverActor])

  sys addShutdownHook {
    println("Shutting down!")
    system.shutdown()
  }

  for (ln <- io.Source.stdin.getLines(); if ln != null || ln != "") {

    sender ! ln

    val selection = system.actorSelection(s"akka.tcp://Akka-Pi@10.1.20.61:2552/user/StringActor")
    selection ! ln
  }
}

package no.bekk.trh.java

import akka.actor.Actor

class ReceiverActor extends Actor {
  override def receive: Receive = {
    case msg => println(s"Received: ${msg.toString}")
  }
}

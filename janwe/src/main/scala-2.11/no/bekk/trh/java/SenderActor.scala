package no.bekk.trh.java

import akka.actor.Actor

class SenderActor extends Actor {
  override def receive: Receive = {
    case msg => {
      println(s"""Sending: "${msg.toString}"""")
    }
  }
}

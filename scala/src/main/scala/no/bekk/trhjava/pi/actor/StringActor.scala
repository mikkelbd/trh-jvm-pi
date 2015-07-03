package no.bekk.trhjava.pi.actor

import akka.actor.{Actor, Props}

object StringActor {
  def mkProps = Props(new StringActor)
}

class StringActor extends Actor {
  override def receive: Receive = {
    case msg : String => println(msg)
  }
}

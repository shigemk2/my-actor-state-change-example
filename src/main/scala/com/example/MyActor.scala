package com.example

import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import akka.event.Logging

class MyActor extends Actor {
  val log = Logging(context.system, this)

  def angry: Receive = {
    case "be angry" => {
      log.info("already angry")
    }
    case "be happy" => {
      log.info("angry -> happy")
      context.become(happy)
    }
    case _ => {
      log.info("unbecome angry")
      context.become
    }
  }
}

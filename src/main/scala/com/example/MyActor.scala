package com.example

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
      context.unbecome
    }
  }

  def happy: Receive = {
    case "be angry" => {
      log.info("happy -> angry")
      context.become(angry)
    }
    case "be happy" => {
      log.info("already happy")
    }
    case _ => {
      log.info("unbecome happy")
      context.unbecome
    }
  }

  def receive = {
    case "be angry" => {
      log.info("become angry")
      context.become(angry)
    }
    case "be happy" => {
      log.info("become happy")
      context.become(happy)
    }
    case _ => {
    }
  }
}

package com.example

import akka.actor.{ActorSystem, Props}

object Hello {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("mySystem")

    val props = Props[MyActor]
    val actor = system.actorOf(props, name = "myActor")

    actor ! "be angry"
    Thread.sleep(1000)

    actor ! "be happy"
    Thread.sleep(1000)

    actor ! "be happy"
    Thread.sleep(1000)

    actor ! "dummy"
    Thread.sleep(1000)

    system.terminate
  }
}

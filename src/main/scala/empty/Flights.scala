package empty

import io.qt.{Script, ScriptObj, builder}

class Flights extends Script {
  def name = Flights.name

  def step0() = {
    //log.info(s"--- $name")
    empty
  }

  val load = builder.LoadSteps(step0)
}

object Flights extends ScriptObj {
  val name = "flights"

  def apply() = new Flights
}
package empty

import io.qt.{Script, ScriptObj, builder}

class Itinerary extends Script {
  def name = Itinerary.name

  def step0() = {
    //log.info(s"--- $name")
    empty
  }

  val load = builder.LoadSteps(step0)
}

object Itinerary extends ScriptObj {
  val name = "itinerary"

  def apply() = new Itinerary
}
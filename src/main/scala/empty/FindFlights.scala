package empty

import io.qt.{Script, ScriptObj, builder}

class FindFlights extends Script {
  def name = FindFlights.name

  def step0() = {
    //log.info(s"--- $name")
    empty
  }

  val load = builder.LoadSteps(step0)
}

object FindFlights extends ScriptObj {
  val name = "find flights"

  def apply() = new FindFlights
}

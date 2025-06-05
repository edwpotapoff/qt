package empty

import io.qt.{Script, ScriptObj, builder}

class SelectionFlights extends Script {
  val name = SelectionFlights.name

  def step0() = {
    //log.info(s"--- $name")
    empty
  }

  val load = builder.LoadSteps(step0)
}

object SelectionFlights extends ScriptObj {
  val name = "selection flights"

  def apply() = new SelectionFlights
}
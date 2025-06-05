package empty

import io.qt.{Script, ScriptObj, builder}

object Continue extends ScriptObj {
  val name = "continue"

  def apply() = new Continue
}

class Continue extends Script {
  def name = Continue.name

  def step0() = {
    //log.info(s"--- $name")
    empty
  }

  val load = builder.LoadSteps(step0)
}


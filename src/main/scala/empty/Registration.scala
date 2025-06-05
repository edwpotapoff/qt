package empty

import io.qt.{Script, ScriptObj, builder}

class Registration extends Script {
  val name = Registration.name

  def step0() = {
    //log.info(s"--- $name")
    empty
  }

  val load = builder.LoadSteps(step0)
}

object Registration extends ScriptObj {
  val name = "registration"

  def apply() = new Registration
}
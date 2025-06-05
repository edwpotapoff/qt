package empty

import io.qt.{Script, ScriptObj, builder}

object SignUp extends ScriptObj {
  val name = "sign up"

  def apply() = new SignUp
}

class SignUp extends Script {
  def name = SignUp.name

  def step0() = {
    //log.info(s"--- $name")
    empty
  }

  val load = builder.LoadSteps(step0)
}

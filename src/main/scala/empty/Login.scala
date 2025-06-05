package empty

import io.qt.{Script, ScriptObj, builder}

class Login extends Script {
  def name = Login.name

  def step0() = log.warning(s"$name $hitId")

  val load = builder.LoadSteps(step0)
}

object Login extends ScriptObj {
  val name = "login"

  def apply() = new Login
}
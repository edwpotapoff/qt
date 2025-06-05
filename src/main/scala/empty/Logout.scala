package empty

import io.qt.{Script, ScriptObj, builder}


class Logout extends Script {
  val name = Logout.name

  def step0() = log.warning(s"$name $hitId")


  val load = builder.LoadSteps(step0)
}

object Logout extends ScriptObj {
  val name = "logout"

  def apply() = new Logout
}
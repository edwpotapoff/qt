package empty

import io.qt.builder.LoadSteps
import io.qt.{Script, ScriptObj, builder}

class OpenSite extends Script {
  def name = OpenSite.name

  def step0() = log.warning(s"$name $hitId")

  val load = LoadSteps(step0)
}

object OpenSite extends ScriptObj {
  val name = "open site"

  def apply() = new OpenSite
}
package scripts.test

import io.qt.builder.Http
import io.qt.{Script, ScriptObj, builder}

object ScriptRom extends ScriptObj {
  def apply() = new ScriptRom
}

class ScriptRom extends Script {
  val name = "rom"

  val req = Http("/users/rom", "lh")
    .make()


  def step1() = req

  val load = builder.LoadSteps(step1)
}

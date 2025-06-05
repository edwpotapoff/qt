package scripts.test

import io.qt.{Script, ScriptObj, builder}


object Count2Subaction extends ScriptObj {
  def apply() = new Count2Subaction
}

class Count2Subaction extends Script {
  val name = "Count2Subaction"

  var count = 0

  def chek() = {
    count += 1
    val x = "x".tc
    log.info(s"chek $x: $count ${callIndex()}")
    empty
  }

  val load = builder.LoadSteps(chek)
}
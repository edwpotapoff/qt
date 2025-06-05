package scripts.test

import io.qt._
import io.qt.builder.Load


object CountSubaction extends ScriptObj {
  def apply() = new CountSubaction
}

class CountSubaction extends Script {
  val name = "CountSubaction"

  val load = Load(
    () => {
      tc("x") = callIndex();
      empty
    }
    , 10 -> Count2Subaction
  )
}
package empty

import io.qt.{Script, ScriptObj, builder}

class DeleteBooking extends Script {
  def name = DeleteBooking.name

  def step0() = {
    //log.info(s"--- $name")
    empty
  }

  val load = builder.LoadSteps(step0)
}

object DeleteBooking extends ScriptObj {
  val name = "delete booking"

  def apply() = new DeleteBooking
}
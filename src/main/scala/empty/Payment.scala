package empty

import io.qt.{Script, ScriptObj, builder}

class Payment extends Script {
  def name = Payment.name

  def step0() = {
    //log.info(s"--- $name")
    empty
  }

  val load = builder.LoadSteps(step0)
}

object Payment extends ScriptObj {
  val name = "payment"

  def apply() = new Payment
}
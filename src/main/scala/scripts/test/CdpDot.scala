package scripts.test

import io.qt.builder.{KafkaSend, Load}
import io.qt.{Script, ScriptObj, builder}

object CdpDot extends ScriptObj {

  def apply() = new CdpDot
}

class CdpDot extends Script {
  val name = "CdpDot"
  val f1 = "./files/dot/f1.json".file()

  val load = Load(
    KafkaSend("producer:{cdp-dot}", body = f1)
  )
}

package scripts.test

import io.qt.builder.{Endpoint, Http, Message}
import io.qt.{Script, ScriptObj, builder}


object SubSubaction extends ScriptObj {
  def apply() = new SubSubaction
}

class SubSubaction extends Script {
  val name = "SubSubaction"

  val req = Http(
    Endpoint("http://localhost:8080/users/anna",
      Map(Type -> GET, Status -> 200, timeout -> 700)
    ),
    Message(null,
      Map(Connection -> keepAlive))
  ).make()


  def step1() = req


  def chek() = {
    val bankId = "BankId".tc
    val bankName = "BankName".tc
    log.info(s"Bank: $bankId, $bankName")
    //assert(false, "test")
    empty
  }

  val load = builder.LoadSteps(step1, chek)
}
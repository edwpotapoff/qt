package scripts.test

import io.qt._
import io.qt.builder.{Endpoint, Http, Message}
import io.qt.builder.Load


object Subaction extends ScriptObj {
  def apply() = new Subaction
}

class Subaction extends Script {
  val name = "Subaction"

  val req = Http(
    Endpoint("http://localhost:8080/users/rom",
      Map(Type -> GET, Status -> 200, timeout -> 700)
    ),
    Message(null,
      Map(Connection -> keepAlive))
  ).make()


  def step1() = req


  val load = Load(
    step1: ST,
    Map(
      "BankId" -> List(1, 2),
      "BankName" -> List("abc", "cda")
    ) -> SubSubaction
  )
}
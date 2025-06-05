package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.{DoSwitch, Load, LoadInit}

import scala.language.postfixOps


class DoSwitchTest extends Script {
  val users = Array("rom", "anna")
  var requests: Array[CO] = _

  def fillRequests() = {
    requests = users.map {
      user =>
        Http(s"lh:/users/$user")
          .make()
    }
    tc("cond") = "rom"
    empty
  }

  override val init = LoadInit(fillRequests)

  def check(name: String) = () => {
    subStr(name)
    asserts
  }

  val cond = () => "anna"

  val load = Load(
    DoSwitch("cond")(
      "rom" -> Load(() => requests(0), check(users(0))),
      "anna" -> Load(() => requests(1), check(users(1)))
    )
  )

  val name = "The DoSwitchTest script "
}

object DoSwitchTest extends ScriptObj {
  def apply() = new DoSwitchTest
}
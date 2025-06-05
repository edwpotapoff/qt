package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.{DoSwitchOrElse, Load, LoadInit}

import scala.language.postfixOps


class DoSwitchOrElseTest extends Script {
  val users = Array("rom", "anna")
  var requests: Array[CO] = _

  def fillRequests() = {
    requests = users.map {
      user =>
        Http(s"lh:/users/$user")
          .make()
    }
    tc("cond") = "abra"
    empty
  }

  override val init = LoadInit(fillRequests)

  def check(name: String) = () => {
    subStr(name)
    asserts
  }

  val cond = () => "anna"

  val rom = Load(() => requests(0), check(users(0)))
  val anna = Load(() => requests(1), check(users(1)))

  val load = Load(
    DoSwitchOrElse("cond")(
      "rom" -> rom,
      "anna" -> anna
    )(
      () => {
        log.info("do else")
        empty
      }
    )
  )

  val name = "The DoSwitchOrElseTest script "
}

object DoSwitchOrElseTest extends ScriptObj {
  def apply() = new DoSwitchOrElseTest
}
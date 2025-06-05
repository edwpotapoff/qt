package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.{ExitHere, Load, LoadInit}

import scala.language.postfixOps


class ExitHereTest extends Script {
  val users = Array("rom", "anna")
  var requests: Array[CO] = _

  def fillRequests() = {
    requests = users.map {
      user =>
        Http(s"lh:/users/$user")
          .make()
    }
    tc("n") = 5
    empty
  }

  override val init = LoadInit(fillRequests)

  def check(name: String) = () => {
    subStr(name)
    asserts
  }

  val rom = Load(() => requests(0), check(users(0)))
  val anna = Load(() => requests(1), check(users(1)))

  val load =
    Load(
      rom
      , ExitHere // = () => stopUser()
      // = StopUser
      , anna
    )

  val name = "The ExitHereTest script "
}

object ExitHereTest extends ScriptObj {
  def apply() = new ExitHereTest
}
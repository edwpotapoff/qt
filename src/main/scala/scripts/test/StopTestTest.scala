package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.{Load, LoadInit}

import scala.language.postfixOps


class StopTestTest extends Script {
  val users = Array("rom", "anna")
  var requests: Array[CO] = _

  def fillRequests() = {
    requests = users.map {
      user =>
        Http(s"lh:/users/$user")
          .make()
    }
    tc("condition") = false
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
      , () => {
        if (state == RUN && testerNum == 1)
        //          stopTest("Тестовая остановка теста") // crash = false
          stopTest("Критическая ошибка", true) // crash = false

        else
          empty
      }

      , anna
    )

  val name = "The StopTestTest script"
}

object StopTestTest extends ScriptObj {
  def apply() = new StopTestTest
}
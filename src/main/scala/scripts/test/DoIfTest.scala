package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.{DoIf, Load, LoadInit, Repeat}

import scala.language.postfixOps


class DoIfTest extends Script {
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

  var firstTime = true

  val cond =
    () =>
      val ret = firstTime
      firstTime = false
      ret


  val rom = Load(() => requests(0), check(users(0)))
  val anna = Load(() => requests(1), check(users(1)))

  val load = Load(
    DoIf(cond)(rom)
    , anna
  )

  val name = "The DoIfTest script"
}

object DoIfTest extends ScriptObj {
  def apply() = new DoIfTest
}
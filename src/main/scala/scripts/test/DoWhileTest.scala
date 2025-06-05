package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.{DoWhile, Load, LoadInit}

import scala.language.postfixOps


class DoWhileTest extends Script {
  val users = Array("rom", "anna")
  var requests: Array[CO] = _

  def fillRequests() = {
    requests = users.map {
      user =>
        Http(s"lh:/users/$user")
          .make()
    }
    empty
  }

  override val init = LoadInit(fillRequests)

  def check(name: String) = () => {
    subStr(name)
    asserts
  }

  var count = 0
  val cond = () => {
    count < 5
  }

  val do1 = // последовательность действий в отдельном объекте
    Seq(
      () => requests(0)
      , check(users(0))
      , () => {
        count += 1
        empty
      }
    )

  val load = Load(
    DoWhile(do1, cond, "count")
    , () => requests(1)
    , check(users(1))
    , () => {
      count = 0
      empty
    }
  )

  val name = "The DoWhileTest script "
}

object DoWhileTest extends ScriptObj {
  def apply() = new DoWhileTest
}
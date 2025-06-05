package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.{Forever, Load, LoadInit}

import scala.language.postfixOps


class ForeverTest extends Script {
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


  val do1 = // последовательность действий в отдельном объекте
    Seq(
      () => requests(0)
      , check(users(0))
    )

  val load = Load(
    Forever(do1, "count")
    , () => requests(1)
    , check(users(1))
  )

  val name = "The ForeverTest script "
}

object ForeverTest extends ScriptObj {
  def apply() = new ForeverTest
}
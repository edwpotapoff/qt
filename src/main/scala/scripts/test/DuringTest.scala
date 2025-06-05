package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.{During, Load, LoadInit}

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class DuringTest extends Script {
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

  val load = Load(
    During(100 millis, "count")(
      () => requests(0)
      , check(users(0))
    )
    , () => requests(1)
    , check(users(1))
  )

  val name = "The DuringTest script "
}

object DuringTest extends ScriptObj {
  def apply() = new DuringTest
}
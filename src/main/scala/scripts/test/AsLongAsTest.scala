package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.{AsLongAs, Load, LoadInit}

import scala.language.postfixOps


class AsLongAsTest extends Script {
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

  val rom = Load(() => requests(0), check(users(0)))
  val anna = Load(() => requests(1), check(users(1)))

  val clean = () => {
    count = 0
    empty
  }

  val countPlus = () => {
    count += 1
    empty
  }

  val load = Load(
    AsLongAs(cond, "count")(rom, countPlus)
    , anna
    , clean
  )

  val name = "The AsLonAsTest script "
}

object AsLongAsTest extends ScriptObj {
  def apply() = new AsLongAsTest
}
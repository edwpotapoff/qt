package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.{Feed, Load, LoadInit}

import scala.language.postfixOps


class FeedTest extends Script {
  val users = Array("rom", "anna")

  override val init = LoadInit(() => {
    tc("users") = users;
    empty
  })


  var request = () => Http("lh:/users/${user}").make()


  val check = () => {
    subStr("user".tc.string)
    asserts
  }


  val feeder = Array(
    Map("user" -> "rom"),
    Map("user" -> "anna")
  ).iterator

  val load = Load(
    Feed(feeder)
    , request
    , check
  )


  val name = "The FeedTest script "
}

object FeedTest extends ScriptObj {
  def apply() = new FeedTest
}
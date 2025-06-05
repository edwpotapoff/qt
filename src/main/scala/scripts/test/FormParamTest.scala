package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.Load

import scala.language.postfixOps


class FormParamTest extends Script {

  val page = Http(s"lhp:/new", POST, body = "flightID=210297424-100296-JB&2=on")
    .make()

  val load =
    Load(
      () => page
    )

  val name = "The FormParamTest script"
}

object FormParamTest extends ScriptObj {
  def apply() = new FormParamTest
}
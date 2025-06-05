package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.{CloseStep, Load}

import scala.language.postfixOps


class CloseTest extends Script {

  val rom = Http(s"lh:/users/rom")
    .make()

  val load =
    Load(
      () => rom
      , CloseStep // () => close()
    )

  val name = "The CloseTest script "
}

object CloseTest extends ScriptObj {
  def apply() = new CloseTest
}
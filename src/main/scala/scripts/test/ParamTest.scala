package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.{CloseStep, Load}

import scala.language.postfixOps


class ParamTest extends Script {

  val page = Http(s"lh:/page?p=1&end=3")
    .make()

  val load =
    Load(
      () => page
    )

  val name = "The ParamTest script "
}

object ParamTest extends ScriptObj {
  def apply() = new ParamTest
}
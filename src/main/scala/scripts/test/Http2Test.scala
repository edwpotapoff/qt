package scripts.test

import io.qt.builder.*
import io.qt.{Script, ScriptObj}

import scala.language.postfixOps


class Http2Test extends Script {
  http2()

  val check = () =>
    asserts

  val load = Load(
    Http("https://127.0.0.1/"),
    check
  )

  val name = "The HttpTest script "
}

object Http2Test extends ScriptObj {
  def apply() = new Http2Test
}

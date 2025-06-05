package scripts.test

import io.qt.builder.*
import io.qt.{Script, ScriptObj}

import scala.language.postfixOps


class HttpTest extends Script {
  val users = Array("rom", "anna")
  var user = 0

  val prepare = () =>
    user = rand(users.size)
    tc("userName") = users(user)

  val check = () =>
    subStr(users(user))
    //bodyStringIS("parameters/expected-template.json".ft) // ElFileBody()
    //bodyStringIS("""{"age":30,"countryOfResidence":"Rus","name":"${userName}"}""".st) // StringBody()
    asserts

  val load = Load(
    prepare,
    Http("/users/${userName}", "lh"),
    check
  )

  val name = "The HttpTest script "
}

object HttpTest extends ScriptObj {
  def apply() = new HttpTest
}

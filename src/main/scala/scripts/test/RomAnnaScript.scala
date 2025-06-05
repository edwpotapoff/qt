package scripts.test

import io.qt._
import io.qt.builder.Http
import io.qt.builder.{LoadInit, LoadSteps}

import scala.language.postfixOps


class RomAnnaScript extends Script {
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


  var user = 0

  def doRequest() = {
    user = rand(users.size)
    tc("userName") = users(user)
    requests(user)
  }

  def assertStep() = {
    subStr(users(user))
    //bodyStringIS("parameters/expected-template.json".ft) // ElFileBody()
    //bodyStringIS("""{"age":30,"countryOfResidence":"Rus","name":"${userName}"}""".st) // StringBody()
    asserts
  }

  override val init = LoadInit(fillRequests)
  val load = LoadSteps(
    doRequest
    , assertStep
  )

  val name = "The Rom Anna script"
}

object RomAnnaScript extends ScriptObj {
  def apply() = new RomAnnaScript
}
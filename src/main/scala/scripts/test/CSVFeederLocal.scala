package scripts.test

import io.qt.builder.LoadInit
import io.qt.{Script, ScriptObj, builder}

object CSVFeederLocal extends ScriptObj {
  def apply() = new CSVFeederLocal
}

class CSVFeederLocal extends Script {
  val name = "script local data"

  var users: LDS = _
  var cities: LDS = _

  def initStep() = {
    users = "./parameters/Users".csv
    cities = "./parameters/Cities".csv(false)
    pass
  }

  def setupStep() = {
    users.next // nextUnique
    cities.next // nextUnique
    pass
  }

  def check0() = {
    val username = tc("username")
    val city = "city".tc
    log.info(s"username $username, city $city, id $hitId")
    empty
  }

  override val init = LoadInit(initStep)

  val load = builder.LoadSteps(setupStep, check0)

}